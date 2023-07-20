package com.iu.main.bankBook;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
//하나만 들어가는 건 value안 써줌
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;

	@RequestMapping(value="list", method =RequestMethod.GET)
	public String getList() throws Exception{
		System.out.println("list");
		bankBookService.service();	
		
		return "bankbook/list";
	}
	
	//method는 기본값이 get
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail() throws Exception{
	    System.out.println("detail");
	  //Model(request와 비슷한 역할) + View(jsp경로)
	    ModelAndView mv = new ModelAndView();
//	    request가 없지만 대체 방법이 2가지 있음
//	    1. MV객체 생성한 후 mv.addObject 활용 -> 리턴
//	    2. 매개변수 ModelAndView받고 mv.addObject 활용 -> 리턴
//	    3. redirect의 경우 view는 적용되어있어서 Model만 따로
//	    매개변수로 받고 리턴은 안해줌(Model은 인터페이스라서 new로 객체 생성이 안됨)
	    mv.addObject("num", 123);
	    mv.setViewName("bankbook/detail"); 
	    return mv;
	}
	//일반 자바와 달리 쓸수있는 리턴타입이 정해져있다
	
	@RequestMapping("add")
	public ModelAndView setAdd(ModelAndView mv) throws Exception{
		int num = 333;
		mv.setViewName("/bankbook/add");
		mv.addObject("num",num);
		return mv;
//		return "bankbook/add";
//		view의 경로명이 없으면 URL주소가 경로명으로 대체됨
//		URL주소와 경로명이 다르면 리턴해주면됨.
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String setAdd(Model model, BankBookDTO bankBookDTO) throws Exception{
//		public String setAdd(Model model, String bookName, Integer bookSale, @RequestParam (name="bookRate", defaultValue = "1.0" ) Double book) throws Exception{
		
		//변수를 선언하면 파라미터에서 해당 값과 같은 이름을 찾아서 변환시켜준다
		//@RequestParam(name, defaultValue)
		//파라미터이름 = dto멤버변수명 = 테이블의 컬럼명 
//		  이 3개를 통일해야됨
		
		int num = 111;
		System.out.println(bankBookDTO.getBookName());
		System.out.println(bankBookDTO.getBookRate());
		System.out.println(bankBookDTO.getBookSale());
		for(int i=0; i<bankBookDTO.getSports().length; i++) {
			System.out.println(bankBookDTO.getSports()[i]);
		}
		System.out.println("===========");
		//**컨트롤러가 받은 내용을 서버로 보내는법** 
		//총 3가지 방법
//		1. 매개변수로 request 선언 후 파라미터값 주고받기
//		2. 래퍼 클래스를 매개변수로 선언하기
//		2.5 @Requestparam
//		3. DTO에서 래퍼 클래스로 선언하고 매개변수로 DTO받아서 작성하고 주기
		
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		System.out.println(bookName);
//		System.out.println(bookSale);
//		System.out.println(bookRate);
		
//		bankBookDTO.setBookName(bookName);
//		bankBookDTO.setBookSale(bookSale);
//		bankBookDTO.setBookRate(bookRate);
//		bankBookDTO.setBookName(request.getParameter("bookName"));
//		bankBookDTO.setBookSale(Integer.parseInt(request.getParameter("bookSale")));
//		
//		String [] sports = request.getParameterValues("sports");
//		파라미터값 여러가지 받을 때 getParameterValues씀	
//		for(int i=0; i<sports.length; i++) {
//			System.out.println(sports[i]);
//		}
		model.addAttribute("num", num);
		return "redirect:./list";
	}
//	Spring에서 리다이렉트 하는법
//	- 문자열로 redirect를 리턴해주면됨
//	절대경로는 "redirect:bankbook/list"; 로 해야됨
	
	@RequestMapping("update")
	public String getUpdate() throws Exception{
		return "bankbook/update";
	}
	
	@RequestMapping("delete")
	public String getDelete() throws Exception{
		return "commons/result";
	}
	//add,update,delete
	
}
//리턴할 수 있는 거 3개 void, String, ModerAndView