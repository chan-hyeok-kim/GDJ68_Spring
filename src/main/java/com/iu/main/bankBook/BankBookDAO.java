package com.iu.main.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.bankBook.bankBookQna.BookQnaDTO;
import com.iu.main.util.Pager;

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
	public List<BankBookDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}

	//detail
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
	 
	   	return sqlSession.selectOne(NAMESPACE+"getDetail",bankBookDTO);
//	   	네임스페이스에 가서 getDetail을 실행하고 결과값을 가져와주세요
//	   	DTO세터이름 컬럼명이 일치하는 애를 찾아서 DTO작성
//	   	mybatis에서 DTO객체를 생성함
	}
	
	//add
//	public BankBookDTO setAdd(BankBookDTO bankBookDTO) throws Exception{
//		return sqlSession.selectOne(NAMESPACE+"setAdd", bankBookDTO);
//	}
	
	public int setAdd(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", bankBookDTO);
	}
	
	//update
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	}
	
	
	//delete
	public int setDelete(Long num) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", num);
	}
//	예시로 Long넣어봄. DTO가 안전함
	
	public void dao() {
		System.out.println("dao");
	}
	
	public Long getTotal(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal",pager);
	}
	
	public int setFile(BankBookFileDTO bankBookFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setFile", bankBookFileDTO);
	}

	public long getSequence()throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSequence");
	}
	
	public List<BookQnaDTO> getCommentList(Map<String, Object> map) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getCommentList", map);
		
	}
	
	public long getCommentTotal(BookQnaDTO bookQnaDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCommentTotal",bookQnaDTO);
	}
}
