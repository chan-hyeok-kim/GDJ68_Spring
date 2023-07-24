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
    public void getList() throws Exception{
    	List<BankBookDTO> ar = bankBookDAO.getList();
    	
    	assertNotEquals(0,ar.size());	
    }
	
	
	
	

}
