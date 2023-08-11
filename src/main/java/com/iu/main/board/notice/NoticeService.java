package com.iu.main.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.bankBook.BankBookFileDTO;
import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardService;
import com.iu.main.file.FileDTO;
import com.iu.main.member.MemberDTO;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

import oracle.net.aso.m;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;

	@Autowired
	private FileManager fileManager;

	public String setContentsImg(MultipartFile file, HttpSession session) throws Exception{
	     String path ="/resources/upload/notice/";
	     String fileName = fileManager.fileSave(path, file, session);
	     
	     return path+fileName;
	}
	
    public boolean setContentsImgDelete(String path,HttpSession session)throws Exception{
    	String fileName = path.substring(path.lastIndexOf("/")+1);
    	path = path.substring(0,path.lastIndexOf("/")+1);
		
		FileDTO fileDTO = new FileDTO();
		fileDTO.setFileName(fileName);
		
    	return fileManager.fileDelete(fileDTO, path, session);
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRowNum();
		pager.makePageNum(noticeDAO.getTotal(pager));
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		boardDTO = noticeDAO.getDetail(boardDTO);
		int result = noticeDAO.setHitUpdate(boardDTO);
		return boardDTO;
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		MemberDTO sessionMember = (MemberDTO) session.getAttribute("login");
		boardDTO.setWriter(sessionMember.getId());
		String path = "/resources/upload/notice/";
		int result = noticeDAO.setAdd(boardDTO);

		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
				String fileName = fileManager.fileSave(path, file, session);
				noticeFileDTO.setBoardNum(boardDTO.getBoardNum());
				noticeFileDTO.setFileName(fileName);
				noticeFileDTO.setOriginalName(file.getOriginalFilename());
				result = noticeDAO.setFile(noticeFileDTO);
			}

		}

		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);

	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {

		MemberDTO sessionMember = (MemberDTO) session.getAttribute("login");
		boardDTO.setWriter(sessionMember.getId());
        
		String path = "/resources/upload/notice/";
		int result = noticeDAO.setUpdate(boardDTO);
		
		
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
				String fileName = fileManager.fileSave(path, file, session);
				noticeFileDTO.setBoardNum(boardDTO.getBoardNum());
				noticeFileDTO.setFileName(fileName);
				noticeFileDTO.setOriginalName(file.getOriginalFilename());
				result = noticeDAO.setFile(noticeFileDTO);
			}

		}

		return result;

		}
	
	

	public int setFileDelete(NoticeFileDTO noticeFileDTO, HttpSession session) throws Exception{
		   noticeFileDTO = noticeDAO.getFileDetail(noticeFileDTO);
//		   조회하는 이유: 파일명을 알아야 지우니깐
		   
		   boolean flag = fileManager.fileDelete(noticeFileDTO, "/resources/upload/notice/", session);
		   if(flag) {
		
		   return noticeDAO.setFileDelete(noticeFileDTO);
		   }
		   return 0;
	}
	
		/*
		 * for (MultipartFile photo : photos) { String fileName =
		 * fileManager.fileSave(path, photo, session);
		  
		  
		  }
		
//		파일네임은 받아온것에서
//		오리지널 네임은 멀티파트에서
// 여기서 삭제하면되겠네 파일
		
	
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
