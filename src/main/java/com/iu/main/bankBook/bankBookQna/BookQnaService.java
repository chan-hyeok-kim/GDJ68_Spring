package com.iu.main.bankBook.bankBookQna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.board.BoardDTO;
import com.iu.main.member.MemberDTO;

@Service
public class BookQnaService{
	
	@Autowired
	private BookQnaDAO bookQnaDAO;

	public List<BookQnaDTO> getList() throws Exception{
		return bookQnaDAO.getList();
	}
	
	public int setReplyAdd(BookQnaDTO bookQnaDTO, HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		bookQnaDTO.setWriter(memberDTO.getId()); 
		
		BoardDTO parentDTO = new BoardDTO();
	
		
		
		return bookQnaDAO.setReplyAdd(bookQnaDTO);
	}
	
}
