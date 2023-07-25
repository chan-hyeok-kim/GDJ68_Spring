package com.iu.main.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.main.member.MemberDAO.";
	
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getLogin", memberDTO);
	}
	
	public int setJoin(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setJoin", memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setMemberUpdate", memberDTO);
	}
	
	
	
	
	
	
	
	
	

}