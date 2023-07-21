package com.iu.main.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.bankBook.BankBookDTO;

@Service
public class studentService {
	
	@Autowired
	private studentDAO dao;
	
	public List<studentDTO> getList() throws Exception{
		return dao.getList();
	}
	
	public studentDTO getDetail(studentDTO dto) throws Exception {
		return dao.getDetail(dto);
	}
	
	public int setAdd(studentDTO dto) throws Exception{
		return dao.setAdd(dto);
	}
	
	public int setUpdate(studentDTO dto) throws Exception{
		return dao.setUpdate(dto);
	}
	
	public int setDelete(studentDTO dto) throws Exception{
		return dao.setDelete(dto);
	}

}
