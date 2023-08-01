package com.iu.main.board;

import java.util.List;

import com.iu.main.util.Pager;

public interface BoardDAO {
	
	public List<BoardDTO> getList(Pager pager)throws Exception;
  
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	
	public int setAdd(BoardDTO boardDTO)throws Exception;

	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	public int setDelete(BoardDTO boardDTO)throws Exception;
	
	public Long getTotal(Pager pager)throws Exception;
	
	public int setHitUpdate(BoardDTO boardDTO)throws Exception;
	
	public int setFile(BoardFileDTO boardFileDTO)throws Exception;
	
}
