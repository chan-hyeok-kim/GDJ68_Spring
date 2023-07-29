package com.iu.main.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.bankBook.BankBookFileDTO;
import com.iu.main.member.MemberDTO;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private FileManager fileManager;
	
	public List<BoardDTO> getList(Pager pager) throws Exception{
		pager.makeRowNum();
		pager.makePageNum(boardDAO.getTotal(pager));
		
		return boardDAO.getList(pager);
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
		return boardDAO.getDetail(boardDTO);
	}
	
	public int setAdd(BoardDTO boardDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception{
		MemberDTO sessionMember = (MemberDTO) session.getAttribute("login");
		boardDTO.setId(sessionMember.getId());
		int result = boardDAO.setAdd(boardDTO);
			
		String path = "/resources/upload/board/";
		
		for(MultipartFile multipartFile: multipartFiles) {
			if(!multipartFile.isEmpty()) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			String fileName = fileManager.fileSave(path, multipartFile, session);
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			result = boardDAO.setFile(boardFileDTO);
			}
		}
		return result;
	}
	
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		return boardDAO.setUpdate(boardDTO);
	}
	
	public int setDelete(BoardDTO boardDTO) throws Exception{
		return boardDAO.setDelete(boardDTO);
	}
	
	

}
