package com.iu.main.board.qna;

import java.security.cert.PolicyQualifierInfo;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardService;
import com.iu.main.member.MemberDTO;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;

	@Autowired
	private FileManager fileManager;

	@Override
	public int setUpdate(BoardDTO boardDTO, HttpSession session) throws Exception {

		MemberDTO sessionMember = (MemberDTO) session.getAttribute("login");
		boardDTO.setWriter(sessionMember.getId());

		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRowNum();
		pager.makePageNum(qnaDAO.getTotal(pager));
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		MemberDTO sessionMember = (MemberDTO) session.getAttribute("login");
		boardDTO.setWriter(sessionMember.getId());
		int result = qnaDAO.setAdd(boardDTO);

		String path = "/resources/upload/board/";
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				QnaFileDTO qnaFileDTO = new QnaFileDTO();
				
				 String fileName = fileManager.fileSave(path, file, session);
				 qnaFileDTO.setBoardNum(boardDTO.getBoardNum());
				 qnaFileDTO.setFileName(fileName);
				 qnaFileDTO.setOriginalName(file.getOriginalFilename()); result =
				 qnaDAO.setFile(qnaFileDTO);
				 
			}
		}

		return result;
	}

	public int setReplyAdd(QnaDTO qnaDTO, MultipartFile[] files, HttpSession session) throws Exception {
		BoardDTO parentDTO = new BoardDTO();
		parentDTO.setBoardNum(qnaDTO.getBoardNum());

		parentDTO = qnaDAO.getDetail(parentDTO);
		QnaDTO p = (QnaDTO) parentDTO;
		qnaDTO.setRef(p.getRef());
		qnaDTO.setStep(p.getStep() + 1);
		qnaDTO.setDepth(p.getDepth() + 1);

		MemberDTO sessionMember = (MemberDTO) session.getAttribute("login");
		qnaDTO.setWriter(sessionMember.getId());

		int result = qnaDAO.setStepUpdate(p);
		result = qnaDAO.setReplyAdd(qnaDTO);

		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setDelete(boardDTO);
	}

}
