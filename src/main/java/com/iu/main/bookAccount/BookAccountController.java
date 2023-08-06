package com.iu.main.bookAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookAccount/*")
public class BookAccountController {

	@Autowired
	private BookAccountService bookAccountService;
	
	
	
	
}
