package com.iu.main.bankBook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.Mytest;

public class BankBookDAOTest extends Mytest {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void addTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		for(int i=0; i<30; i++) {
		bankBookDTO.setBookName("월급통장"+i);
		bankBookDTO.setBookContents("입금내역"+i);
		bankBookDTO.setBookRate(4.5);
		bankBookDTO.setBookSale(1);
		bankBookDAO.setAdd(bankBookDTO);
		}
		
		System.out.println("Finish");
	}
	
	
//	@Test
//    public void getList() throws Exception{
//    	List<BankBookDTO> ar = bankBookDAO.getList();
//    	
//    	assertNotEquals(0,ar.size());	
//    }
	
	
	
	

}
