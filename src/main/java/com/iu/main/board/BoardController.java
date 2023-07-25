package com.iu.main.board;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("list")
	public String getList(Model model)throws Exception{
		List<BoardDTO> ar = boardService.getList();
		model.addAttribute("list", ar);
		return "board/list";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		boardDTO = boardService.getDetail(boardDTO);
		mv.addObject("board", boardDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	
	@RequestMapping(value = "add", method=RequestMethod.GET)
	public String setAdd() throws Exception{
		return "board/add";
	}
	
	@RequestMapping(value="add",method = RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO) throws Exception{
		int result = boardService.setAdd(boardDTO);
		return "redirect:./list";
	}
//	redirect는 상대, 절대 다됨
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		boardDTO = boardService.getDetail(boardDTO);
		mv.addObject("mto", boardDTO);
		mv.setViewName("board/update");
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		int result = boardService.setUpdate(boardDTO);
		return "redirect:./detail?boardNum="+boardDTO.getBoardNum();
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception{
		int result= boardService.setDelete(boardDTO);
		return "redirect:./list";
	}
	
	@RequestMapping("search")
	public ModelAndView getSearch(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		List<BoardDTO> ar = boardService.getSearch(boardDTO);
		mv.addObject("mto",ar);
		mv.setViewName("board/search");
	    return mv;
	}
	
	
	
	

}
