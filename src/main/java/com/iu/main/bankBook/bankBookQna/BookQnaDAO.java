package com.iu.main.bankBook.bankBookQna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.board.BoardDAO;
import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardFileDTO;
import com.iu.main.util.Pager;

@Repository
public class BookQnaDAO{

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.main.bankBook.bankBookQna.BookQnaDAO.";
	
	
	public List<BookQnaDTO> getList() throws Exception{
		   return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public int setReplyAdd(BookQnaDTO bookQnaDTO) throws Exception{
		   return sqlSession.insert(NAMESPACE+"setReplyAdd", bookQnaDTO);
	}
	
	public int setStepUpdate(BookQnaDTO bookQnaDTO) throws Exception{
		   return sqlSession.update(NAMESPACE+"setStepUpdate", bookQnaDTO);
	}
	
	public BookQnaDTO getDetail(BookQnaDTO bookQnaDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", bookQnaDTO);
	}
}
