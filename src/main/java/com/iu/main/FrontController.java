package com.iu.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

	
	//home 메서드명
    // / 주소가 왔을 때 실행, index.jsp
	
	@RequestMapping(value="/")
	public String home() throws Exception {
		
		return "index";
	}
	
	
}
