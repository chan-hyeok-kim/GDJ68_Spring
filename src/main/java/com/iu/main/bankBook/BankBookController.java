package com.iu.main.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
//하나만 들어가는 건 value안 써줌
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;

	@RequestMapping(value="list", method =RequestMethod.GET)
	public String getList(Model model) throws Exception{
		List<BankBookDTO> ar = bankBookService.getList();
		System.out.println();
		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	//method는 기본값이 get
	@RequestMapping("detail")
	public ModelAndView getDetail(BankBookDTO bankBookDTO,ModelAndView mv) throws Exception{
 	    bankBookDTO = bankBookService.getDetail(bankBookDTO);
	    System.out.println(bankBookDTO.getBookName());
	    mv.addObject("dto", bankBookDTO);
	    mv.setViewName("bankbook/detail");
	    return mv;
	}
	
	@RequestMapping("add")
	public ModelAndView setAdd(ModelAndView mv) throws Exception {
		   mv.setViewName("/bankbook/add");
		   return mv;
	}
	
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(BankBookDTO bankBookDTO, Model model) throws Exception{
		bankBookDTO = bankBookService.setAdd(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
		return "redirect:./list";
	}

	
	@RequestMapping("update")
	public String setUpdate() throws Exception{
		return "bankbook/update";
	}
	
//	@RequestMapping(value="update", method = RequestMethod.POST)
//	public String setUpdate
//	
//	
//	
//	
//	
//	
//	
//	@RequestMapping("delete")
//	public String getDelete() throws Exception{
//		return "commons/result";
//	}
	//add,update,delete
	
	
}