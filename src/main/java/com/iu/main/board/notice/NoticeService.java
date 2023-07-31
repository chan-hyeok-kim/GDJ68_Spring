package com.iu.main.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.bankBook.BankBookFileDTO;
import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardService;
import com.iu.main.member.MemberDTO;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

import oracle.net.aso.m;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO boardDAO;

	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRowNum();
		pager.makePageNum(boardDAO.getTotal(pager));
		return boardDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
	//	int result = boardDAO.setHitUpdate(boardDTO);
		return boardDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		String path = "/resources/upload/board/";

		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
				String fileName = fileManager.fileSave(path, file, session);
                noticeFileDTO.getBoardNum();
                noticeFileDTO.getBoardNum();
                noticeFileDTO.getBoardNum();
			}

		}

		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return boardDAO.setDelete(boardDTO);

	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return boardDAO.setUpdate(boardDTO);
	}

	/*
	 * public List<BoardDTO> getList(Pager pager) throws Exception{
	 * pager.makeRowNum(); pager.makePageNum(boardDAO.getTotal(pager));
	 * 
	 * return boardDAO.getList(pager); }
	 * 
	 * public BoardDTO getDetail(NoticeDTO boardDTO) throws Exception{
	 * boardDAO.setHitUpdate(boardDTO); return boardDAO.getDetail(boardDTO); }
	 * 
	 * public int setAdd(NoticeDTO boardDTO, MultipartFile[] multipartFiles,
	 * HttpSession session) throws Exception{ MemberDTO sessionMember = (MemberDTO)
	 * session.getAttribute("login"); boardDTO.setId(sessionMember.getId()); int
	 * result = boardDAO.setAdd(boardDTO);
	 * 
	 * String path = "/resources/upload/board/";
	 * 
	 * for(MultipartFile multipartFile: multipartFiles) {
	 * if(!multipartFile.isEmpty()) { NoticeFileDTO noticeFileDTO = new
	 * NoticeFileDTO(); String fileName = fileManager.fileSave(path, multipartFile,
	 * session); noticeFileDTO.setBoardNum(boardDTO.getBoardNum());
	 * noticeFileDTO.setFileName(fileName);
	 * noticeFileDTO.setOriginalName(multipartFile.getOriginalFilename()); result =
	 * boardDAO.setFile(noticeFileDTO); } } return result; }
	 * 
	 * public int setUpdate(NoticeDTO boardDTO) throws Exception{ return
	 * boardDAO.setUpdate(boardDTO); }
	 * 
	 * public int setDelete(NoticeDTO boardDTO) throws Exception{ return
	 * boardDAO.setDelete(boardDTO); }
	 */

}
