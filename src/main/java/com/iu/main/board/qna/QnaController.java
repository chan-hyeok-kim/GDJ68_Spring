package com.iu.main.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.board.BoardDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoardName() {
		return "QnA";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList(ModelAndView mv, Pager pager)throws Exception{
		List<BoardDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		return mv;
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String setAdd() throws Exception{
		
		return "board/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String setAdd(QnaDTO qnaDTO,MultipartFile[] files, HttpSession session) throws Exception{
	
		int result = qnaService.setAdd(qnaDTO, files, session);
			return "redirect:./list";
		
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(Model model, QnaDTO qnaDTO) throws Exception{
		BoardDTO boardDTO = qnaService.getDetail(qnaDTO);
		model.addAttribute("bto",boardDTO);
		return "board/detail";
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String setReply(QnaDTO qnaDTO, Model model)throws Exception{
		model.addAttribute("bto", qnaDTO);
		return "board/reply";
			
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String setReply(QnaDTO qnaDTO, MultipartFile[] files, HttpSession session)throws Exception{
		int result = qnaService.setReplyAdd(qnaDTO, files, session);
		
		return "redirect:./list";
	}
	
//	public void setQna(QnaDTO qnaDTO, )
//	if(qnaDTO!=) {
//		int result = qnaService.setQna(qnaDTO, files, session)
//		return "redirect:./detail";	
	
	@RequestMapping(value = "update",method = RequestMethod.GET)
	public ModelAndView setUpdate(QnaDTO qnaDTO,ModelAndView mv) throws Exception{
		BoardDTO boardDTO = qnaService.getDetail(qnaDTO);
		mv.addObject("bto",boardDTO);
		mv.setViewName("board/update");
		return mv;
	}
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public String setUpdate(QnaDTO qnaDTO, HttpSession session) throws Exception{
		int result = qnaService.setUpdate(qnaDTO, session);
        return "redirect:./list";
		//		return "redirect:./detail?boardNum"+qnaDTO.getBoardNum();
	}
	
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String setDelete(QnaDTO qnaDTO)throws Exception{
		qnaService.setDelete(qnaDTO);
		return "redirect:./list";
	}
	
	
	
}
