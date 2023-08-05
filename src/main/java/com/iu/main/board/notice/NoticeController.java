package com.iu.main.board.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.board.BoardDTO;
import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService boardService;
	
	@ModelAttribute("board")
	public String getBoardName() {
		return "NOTICE";
	}
	
	@RequestMapping("list")
	public String getList(Model model,Pager pager)throws Exception{
		List<BoardDTO> ar = boardService.getList(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager",pager);
		return "./board/list";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String getDetail(NoticeDTO noticeDTO, Model model) throws Exception{
	
		BoardDTO boardDTO = boardService.getDetail(noticeDTO);
		model.addAttribute("bto", boardDTO);
		return "board/detail";
	
	}
	
	@RequestMapping(value = "add", method=RequestMethod.GET)
	public String setAdd() throws Exception{
		return "board/add";
	}
	
	@RequestMapping(value="add",method = RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception{
		int result = boardService.setAdd(boardDTO, files, session);
		return "redirect:./list";
	}
//	redirect는 상대, 절대 다됨
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setUpdate(NoticeDTO noticeDTO, ModelAndView mv) throws Exception{
		BoardDTO boardDTO = boardService.getDetail(noticeDTO);
		mv.addObject("bto", boardDTO);
		mv.setViewName("board/update");
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO boardDTO, HttpSession session) throws Exception{
		int result = boardService.setUpdate(boardDTO, session);
		return "redirect:./detail?boardNum="+boardDTO.getBoardNum();
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String setDelete(NoticeDTO boardDTO) throws Exception{
		int result= boardService.setDelete(boardDTO);
		return "redirect:./list";
	}
	
	
	
	
	
	

}
