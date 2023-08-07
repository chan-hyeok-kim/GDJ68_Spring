package com.iu.main.bookAccount;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.Mytest;
import com.iu.main.util.Pager;

public class BookAccountDAOTest extends Mytest {

	@Autowired
	private BookAccountDAO bookAccountDAO;

//	@Test
	public void getListTest() throws Exception {
		Pager pager = new Pager();
		pager.setStartRow(1L);
		List<BookAccountDTO> ar = bookAccountDAO.getList(pager);

		assertEquals(0, ar.size());
	

	}
	
	@Test
	public void setAddTest() throws Exception {
		BookAccountDTO dto = new BookAccountDTO();
		dto.setId("id67467");
		dto.setBookNum(181L);
		dto.setAccount(9084536L);
		dto.setAccountBalance(0L);
		dto.setAccountPassword("5039");
		
		int result = bookAccountDAO.setAdd(dto);
		
		assertNotEquals(0, result);
	}
	
//	@Test
	public void setDeleteTest()throws Exception{
		BookAccountDTO bookAccountDTO = new BookAccountDTO();
		bookAccountDTO.setAccountNum(18L);
		int result = bookAccountDAO.setDelete(bookAccountDTO);
	}

}
