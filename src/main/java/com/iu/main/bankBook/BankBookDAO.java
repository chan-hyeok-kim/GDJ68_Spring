package com.iu.main.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //해당 클래스의 객체를 생성하세요
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.iu.main.bankBook.BankBookDAO.";
	//뒤에 . 추가
	//이 네임스페이스의 쿼리/메서드(id)를 실행하려고 .넣는것
	
	
	
	
	//list
	//detail
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
	
	   	return sqlSession.selectOne(NAMESPACE+"getDetail",bankBookDTO);
//	   	네임스페이스에 가서 getdetail을 실행하고 결과값을 가져와주세요
	}
	
	//add
	//update
	//delete
	
	public void dao() {
		System.out.println("dao");
	}

}
