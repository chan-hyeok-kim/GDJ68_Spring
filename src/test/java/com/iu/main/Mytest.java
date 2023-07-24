package com.iu.main;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iu.main.bankBook.BankBookDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
// web.xml에서 못읽기때문에 읽어주게하기위함
public abstract class Mytest {

//	@Autowired
//	private BankBookDAO bankBookDAO;
//	
//	@Test
//	public void deleteTest() throws Exception {
//	  int result=bankBookDAO.setDelete(1031L);
//	  
//	  assertNotEquals(0, result);
//	  
////	  단정문 assert
////	  result값이 0이 아니길 희망한다.
////	  0이면 실패(삭제못했다)
//	}

}
