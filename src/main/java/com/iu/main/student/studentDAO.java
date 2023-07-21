package com.iu.main.student;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.bankBook.BankBookDTO;

@Repository
public class studentDAO {
	
    @Autowired
	private SqlSession sqlSession;
	
    private final String NAMESPACE="com.iu.main.student.studentDAO.";
    
	public List<studentDTO> getList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public studentDTO getDetail(studentDTO dto) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail",dto);
	}

}
