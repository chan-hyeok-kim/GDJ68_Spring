package com.iu.main.bankBook;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.PageData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.bankBook.bankBookQna.BookQnaDTO;
import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {
	//하나만 들어가는 건 value안 써줌
	
	@Autowired
	private BankBookService bankBookService;

//	Comment
	@GetMapping("commentList")
	public void getCommentList(BookQnaDTO bookQnaDTO, Pager pager,Model model) throws Exception{
		pager.setPerPage(2L);
		List<BookQnaDTO> ar = bankBookService.getCommentList(pager, bookQnaDTO);
		model.addAttribute("commentList",ar);
	    model.addAttribute("pager", pager);
	}
	

	
	@PostMapping("commentAdd")
    public String setCommentAdd(BookQnaDTO bookQnaDTO,HttpSession session,Model model) throws Exception{
	    MemberDTO memberDTO = (MemberDTO)session.getAttribute("login");
	    bookQnaDTO.setWriter(memberDTO.getId());
	    
		int result = bankBookService.setCommentAdd(bookQnaDTO);
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
//	    return "redirect:./detail?bookNum="+bookQnaDTO.getBookNum();
	}
	
	
//	BankBook
	@RequestMapping(value="list", method =RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception{
		List<BankBookDTO> ar = bankBookService.getList(pager);
		System.out.println();
		model.addAttribute("list", ar);
		model.addAttribute("pager",pager);
		return "bankbook/list";
	}
	
//	파라미터값 받기
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
	public String setAdd(BankBookDTO bankBookDTO, MultipartFile[] photos, HttpSession session) throws Exception{
		int result= bankBookService.setAdd(bankBookDTO, photos, session);
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
