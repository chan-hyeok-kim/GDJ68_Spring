package com.iu.main.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void setAdd() throws Exception{
	}

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String setAdd(studentDTO dto) throws Exception{
    	dto.setTotal(dto.getKor()+dto.getEng()+dto.getMath());
    	dto.setAvg(dto.getTotal()/3.0);
    	int result = service.setAdd(dto);
    	return "redirect:./list";
    }
    
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public void setUpdate(studentDTO dto, Model model) throws Exception {
    	dto = service.getDetail(dto);
    	model.addAttribute("sto",dto);
    }
    
    @RequestMapping(value = "update", method=RequestMethod.POST)
    public String setUpdate(studentDTO dto) throws Exception {
    	dto.setTotal(dto.getKor()+dto.getEng()+dto.getMath());
    	dto.setAvg(dto.getTotal()/3.0);
    	int result = service.setUpdate(dto);
    	return "redirect:./detail?num="+dto.getNum();
    }
    
    @RequestMapping("delete")
    public String setDelete(studentDTO dto) throws Exception {
       int result = service.setDelete(dto);
       return "redirect:./list";
    }
    
    
}
