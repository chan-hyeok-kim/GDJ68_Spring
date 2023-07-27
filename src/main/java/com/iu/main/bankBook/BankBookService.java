package com.iu.main.bankBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.util.Pager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		 return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public List<BankBookDTO> getList(Pager pager) throws Exception{
//		Map<String,Long> map = new HashMap<String,Integer>();
//		
		pager.makeRowNum();
		Long total = bankBookDAO.getTotal(pager);
		pager.makePageNum(total);
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
		return bankBookDAO.getList(pager);
	}
	
	public int setAdd(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setAdd(bankBookDTO);
	}
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	public int setDelete(Long num) throws Exception{
		return bankBookDAO.setDelete(num);
	}
	
	

	

}
