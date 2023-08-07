package com.iu.main.bookAccount;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/bookAccount/*")
public class BookAccountController {

	@Autowired
	private BookAccountService bookAccountService;

	@GetMapping("list")
	public ModelAndView getList(HttpSession session, Pager pager) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("login");
		
		List<BookAccountDTO> ar = bookAccountService.getList(memberDTO, pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("bookAccount/list");
		return mv;
	}

	@GetMapping("add")
	public void setAdd(BookAccountDTO bookAccountDTO, Model model) throws Exception {
		model.addAttribute("dto", bookAccountDTO);
	}

	@PostMapping("add")
	public String setAdd(BookAccountDTO bookAccountDTO, HttpSession session, Model model) throws Exception {
		MemberDTO sessionMember = (MemberDTO) session.getAttribute("login");
		bookAccountDTO.setId(sessionMember.getId());
		int result = bookAccountService.setAdd(bookAccountDTO);
        
//		String message = "상품 가입이 실패했습니다";
//
//		if (result > 0) {
//			message = "상품 가입이 완료되었습니다";
//
//		}
//		model.addAttribute("message", message);
//		model.addAttribute("url", "/");
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}

}
