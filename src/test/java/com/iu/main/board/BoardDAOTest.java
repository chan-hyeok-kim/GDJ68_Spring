package com.iu.main.board;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.Mytest;
import com.iu.main.bankBook.BankBookDAO;
import com.iu.main.bankBook.BankBookDTO;
import com.iu.main.board.notice.NoticeDAO;
import com.iu.main.board.notice.NoticeDTO;

public class BoardDAOTest extends Mytest{

	@Autowired
    private NoticeDAO boardDAO;
	
	@Autowired
	private NoticeDTO boardDTO;
	
//	@Test
	public void boardTest() throws Exception{
		
		boardDTO.setBoardContents("실험");
		boardDAO.setAdd(boardDTO);
		
		assertNotEquals("실험",boardDTO);
		
	}
//	public void addTest() throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		
//		for(int i=0; i<30; i++) {
//			boardDTO.setBoardName("월급통장"+i);
//			boardDTO.setBoardContents("입금내역"+i);
//			boardDTO.setBoard(4.5);
//			boardDTO.setBoardSale(1);
//			boardDTO.setAdd(bankBookDTO);
//		}
//		
//		System.out.println("Finish");
//	}
//	
//	

}
