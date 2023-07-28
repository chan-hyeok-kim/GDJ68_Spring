package com.iu.main.board;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("detail")
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception{
		boardDTO = boardService.getDetail(boardDTO);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}
	
	@RequestMapping("list")
	public ModelAndView getList(ModelAndView mv) throws Exception {
		List<BoardDTO> ar = boardService.getList();
		mv.addObject("list",ar);
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public void setDelete()throws Exception{
		
	}
	
//	@RequestMapping(value = "delete", method = )
//	public setDelete(NoticeBoardDTO noticeBoardDTO)
//	
	
	
	
	
	
	
}
