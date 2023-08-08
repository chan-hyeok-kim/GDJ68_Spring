package com.iu.main.member;

import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.util.FileManager;

@Controller
@RequestMapping("/member/*") 
// **은 폴더 포함
public class MemberController {
    //BankBookController, GET
	//MemberController, GET
	//주소 .do 삭제
    // /member/login
	
	@Autowired
	private MemberService memberService;
	
//	로그인 폼으로 이동하는 것
	@RequestMapping(value = "login", method= RequestMethod.GET)
	public void getLogin() throws Exception{
	}
	
	@RequestMapping(value = "login", method=RequestMethod.POST)
	public String getLogin(MemberDTO memberDTO, HttpSession session)throws Exception{
		memberDTO = memberService.getLogin(memberDTO);
		
		if(memberDTO!=null) {
			session.setAttribute("login", memberDTO);		
//			상대경로면 ../까지만
		}
		return "redirect:/";
	}
	
	@RequestMapping("logout")
	public String getLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
//	파라미터 값 받는 법
//	1. request
//	2. 변수
//	3. dto에 담기 (파라미터타입과 이름이 같아야함)
	
//	로그인 방법
//	1. request 매개 변수 선언해서 session꺼내기
//  2. session 선언
	
	
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void setJoin() throws Exception {	
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String setJoin(MemberDTO memberDTO,MultipartFile pic, HttpSession session,Model model) throws Exception {
		
		int result = memberService.setJoin(memberDTO, pic, session);
		System.out.println(pic.getName());
		System.out.println(pic.getOriginalFilename());
		System.out.println(pic.getSize());
		
		return "redirect:/";
	}
//	파라미터 이름과 동일한변수
	
	@RequestMapping(value="myPage", method = RequestMethod.GET)
	public void getMyPage() throws Exception {
		
		
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
	public void setMemberUpdate() throws Exception{
		
	}

	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public String setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception{
		MemberDTO sessionMember = (MemberDTO) session.getAttribute("login");
		memberDTO.setId(sessionMember.getId());
		int result = memberService.setMemberUpdate(memberDTO);
		if(result>0) {
			session.setAttribute("login", memberDTO);
		}
		return "redirect:./myPage";
	}
	
	@GetMapping("idCheck")
	public String getIdCheck(MemberDTO memberDTO, Model model) throws Exception{
		   memberDTO = memberService.getIdCheck(memberDTO);
		   
		   int result = 0;
		   
		   if(memberDTO==null) {
			   result = 1;
		   }
		   
		   
		   model.addAttribute("result",result);
		   return "commons/ajaxResult";
			    
	}
	
}
