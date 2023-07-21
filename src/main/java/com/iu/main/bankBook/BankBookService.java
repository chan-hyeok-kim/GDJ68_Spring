package com.iu.main.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		 return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public List<BankBookDTO> getList() throws Exception{
		return bankBookDAO.getList();
	}
	
	public BankBookDTO setAdd(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setAdd(bankBookDTO);
	}
	
	public BankBookDTO setUpdate(BankBookDTO bankBookDTO) throws Exception{
	    return bankBookDAO.setUpdate(bankBookDTO);	
	}

}
