package com.iu.main.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository //해당 클래스의 객체를 생성하세요
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
//	sqlsession이 담고 있는 정보
//	db연결, 매퍼들의 위치
	
	private final String NAMESPACE = "com.iu.main.bankBook.BankBookDAO.";
	//뒤에 . 추가
	//이 네임스페이스의 쿼리/메서드(id)를 실행하려고 .넣는것
//   클래스명까지 쓰자.인데 클래스명은 중복이 되니 패키지명까지 씀
	
	
	//list
	public List<BankBookDTO> getList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	//detail
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
	   	return sqlSession.selectOne(NAMESPACE+"getDetail",bankBookDTO);
//	   	네임스페이스에 가서 getDetail을 실행하고 결과값을 가져와주세요
//	   	DTO세터이름 컬럼명이 일치하는 애를 찾아서 DTO작성
//	   	mybatis에서 DTO객체를 생성함
	}
	
	//add
	public BankBookDTO setAdd(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"setAdd", bankBookDTO);
	}
	
	//update
	public BankBookDTO setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"setUpdate",bankBookDTO);
	}
	
	//update
	
	//delete
	
	public void dao() {
		System.out.println("dao");
	}

}
