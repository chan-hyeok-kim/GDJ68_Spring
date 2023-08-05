package com.iu.main.bookAccount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.util.Pager;

import oracle.net.aso.b;

@Repository

public class BookAccountDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.main.bookAccount.BookAccountDAO.";
	
	
	public List<BookAccountDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}
	
	public BookAccountDTO getDetail(BookAccountDTO bookAccountDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", bookAccountDTO);
	}
	
	public int setAdd(BookAccountDTO bookAccountDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", bookAccountDTO);
	}
	
	public int setUpdate(BookAccountDTO bookAccountDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", bookAccountDTO);	
	}
	
	public int setDelete(BookAccountDTO bookAccountDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", bookAccountDTO);
	}
	
	
	
	
	
}
