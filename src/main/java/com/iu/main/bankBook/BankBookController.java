package com.iu.main.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.util.Pager;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {
	//하나만 들어가는 건 value안 써줌
	
	@Autowired
	private BankBookService bankBookService;

	@RequestMapping(value="list", method =RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception{
		List<BankBookDTO> ar = bankBookService.getList(pager);
		System.out.println();
		model.addAttribute("list", ar);
		model.addAttribute("pager",pager);
		return "bankbook/list";
	}
	
//	request 
//	bean
//  파라미터값과 같은 이름의 매개변수선언
	
	//method는 기본값이 get
	@RequestMapping("detail")
	public ModelAndView getDetail(BankBookDTO bankBookDTO,ModelAndView mv) throws Exception{
 	    bankBookDTO = bankBookService.getDetail(bankBookDTO);
	    System.out.println(bankBookDTO.getBookName());
	    mv.addObject("dto", bankBookDTO);
	    mv.setViewName("bankbook/detail");
	    return mv;
	}
	
//	@RequestMapping("add")
//	public ModelAndView setAdd(ModelAndView mv) throws Exception {
//		   mv.setViewName("/bankbook/add");
//		   return mv;
//	}
	
	
	@RequestMapping("add")
	public void setAdd() throws Exception {
		 
	}
	//void인 경우 /bankbook/add로감 맵핑해놓은것 때문에 
//	form으로 이동하는 add
//	 
	
//	@RequestMapping(value="add", method = RequestMethod.POST)
//	public String setAdd(BankBookDTO bankBookDTO, Model model) throws Exception{
//		int result= bankBookService.setAdd(bankBookDTO);
//		model.addAttribute("dto", bankBookDTO);
//		return "redirect:./list";
//	}
	//db insert
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(BankBookDTO bankBookDTO) throws Exception{
		int result= bankBookService.setAdd(bankBookDTO);
		return "redirect:./list";
	}
	
	//수정 form
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void setUpdate(BankBookDTO bankBookDTO, Model model) throws Exception{
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("dto",bankBookDTO);
	}
	
	//DB update
	 @RequestMapping(value="update", method=RequestMethod.POST) 
	 public String setUpdate(BankBookDTO bankBookDTO) throws Exception{
	     int result = bankBookService.setUpdate(bankBookDTO);
	     return "redirect:./detail?bookNum="+bankBookDTO.getBookNum(); 
	 }
//	 디테일로 갈때 booknum을 보내주기로 했기 때문에
	
	
	
	@RequestMapping("delete")
	public String setDelete(Long bookNum) throws Exception{
		int result = bankBookService.setDelete(bookNum);
		return "redirect:/bankbook/list";
	}
//	DB와 일
//	@RequestParam(name="booknum") Long num 으로 쓸수도있
	
}
