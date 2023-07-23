package com.iu.main.noticeBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/noticboard/*")
public class NoticeBoardController {

	@Autowired
	private NoticeBoardService noticeBoardService;
	
	@RequestMapping("detail")
	public void getDetail() throws Exception{
		
	}
	
}
