package com.iu.main.bankBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bankbook/*")
//하나만 들어가는 건 value안 써줌
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;

	@RequestMapping(value="list", method =RequestMethod.GET)
	public String getList() throws Exception{
		System.out.println("list");
		
		return "bankbook/list";
	}
	
	//method는 기본값이 get
	@RequestMapping("detail")
	public String getDetail(BankBookDTO bankBookDTO) throws Exception{
 	    bankBookDTO = bankBookService.getDetail(bankBookDTO);
	    System.out.println(bankBookDTO.getBookName());
	    return "bankbook/detail";
	}
	
	@RequestMapping("add")
	public String getAdd() throws Exception{
		return "bankbook/add";
	}
	
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
