package com.iu.main.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.util.Pager;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardDTO> getList(Pager pager) throws Exception{
		pager.makeRowNum();
		pager.makePageNum(boardDAO.getTotal());
		
		return boardDAO.getList(pager);
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
		return boardDAO.getDetail(boardDTO);
	}
	
	public int setAdd(BoardDTO boardDTO) throws Exception{
		return boardDAO.setAdd(boardDTO);
	}
	
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		return boardDAO.setUpdate(boardDTO);
	}
	
	public int setDelete(BoardDTO boardDTO) throws Exception{
		return boardDAO.setDelete(boardDTO);
	}
	
	public List<BoardDTO> getSearch(BoardDTO boardDTO) throws Exception{
		return boardDAO.getSearch(boardDTO);
	}

}
