package com.iu.main.bookAccount;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class BookAccountDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.main.bookAccount.BookAccountDAO.";
	
	
	
}
