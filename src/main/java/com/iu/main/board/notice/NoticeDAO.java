package com.iu.main.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.util.Pager;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.main.board.notice.NoticeDAO.";
	
	public List<NoticeDTO> getList(Pager pager) throws Exception{
	     return sqlSession.selectList(NAMESPACE+"getList",pager);	
	}
	
	public NoticeDTO getDetail(NoticeDTO boardDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}
	
	public int setAdd(NoticeDTO boardDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", boardDTO);
	}
	
	public int setUpdate(NoticeDTO boardDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}
	
	public int setDelete(NoticeDTO boardDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}
	
	
	public Long getTotal(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal", pager);
	}
	
	public int setFile(NoticeFileDTO boardFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setFile",boardFileDTO);
	}
	

}
