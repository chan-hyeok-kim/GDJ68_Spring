package com.iu.main.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.bankBook.BankBookDTO;

@Controller
@RequestMapping("/student/*")
public class studentController {

	@Autowired
	private studentService service;
	
	@RequestMapping("list")
	public String getList(Model model) throws Exception {
		List<studentDTO> ar= service.getList();
		model.addAttribute("list",ar);
		return "student/list";
	}
	
	@RequestMapping("detail")
	public ModelAndView getDetail(studentDTO dto,ModelAndView mv) throws Exception {
		   dto = service.getDetail(dto);
		   mv.addObject("sto", dto);
		   mv.setViewName("student/detail");
		   return mv;
	}

    	
}
