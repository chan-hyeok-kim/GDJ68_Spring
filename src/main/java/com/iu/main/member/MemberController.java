package com.iu.main.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {
    //BankBookController, GET
	//MemberController, GET
	//주소 .do 삭제
    // /member/login
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("myPage")
	public String mypage() {
		return "member/myPage";
	}
	
	@RequestMapping("join")
	public String join() {
		return "member/join";
	}
	
//	@RequestMapping("logout")
	
	
	
}
