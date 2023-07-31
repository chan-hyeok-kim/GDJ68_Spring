package com.iu.main.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList(ModelAndView mv, Pager pager)throws Exception{
		List<QnaDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("qna/list");
		return mv;
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String setAdd() throws Exception{
		
		return "qna/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public int setAdd(QnaDTO qnaDTO) throws Exception{
	    int result = 1;
	    return result;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(QnaDTO qnaDTO) throws Exception{
		
	}
	
	
	
}
