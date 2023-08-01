package com.iu.main.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.iu.main.util.Pager;

public interface BoardService {
 
	public List<BoardDTO> getList(Pager pager) throws Exception;

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception;

	public int setUpdate(BoardDTO boardDTO,HttpSession session) throws Exception;

    public int setDelete(BoardDTO boardDTO) throws Exception;
    
   

}
