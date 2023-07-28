package com.iu.main.bankBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class BankBookService {

	@Autowired
	private BankBookDAO bankBookDAO;

	@Autowired
	private FileManager fileManager;

	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.getDetail(bankBookDTO);
	}

	public List<BankBookDTO> getList(Pager pager) throws Exception {
//		Map<String,Long> map = new HashMap<String,Integer>();
//		
		pager.makeRowNum();
		Long total = bankBookDAO.getTotal(pager);
		pager.makePageNum(total);
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
		return bankBookDAO.getList(pager);
	}

	public int setAdd(BankBookDTO bankBookDTO, MultipartFile[] files, HttpSession session) throws Exception {
	
		int result = bankBookDAO.setAdd(bankBookDTO);
		String path = "/resources/upload/bankbook/";
//		bankBookDTO의 bookNum을 얻는 법. 
//		1. sql로 가장 큰 수로 호출 - 문제가 있음. 그 사이에 다른사람이 우연히 insert하면 불가
//		2. mapper에서 sql문을 만들어서 시퀀스를 먼저 실행시킨다
//		3. selectKey 이용
		
		for (MultipartFile multipartFile : files) {
			if (multipartFile.isEmpty()) {
			    continue;	
			}
				String fileName = fileManager.fileSave(path, multipartFile, session);
				BankBookFileDTO bankBookFileDTO = new BankBookFileDTO();
				bankBookFileDTO.setBookNum(bankBookDTO.getBookNum());
				bankBookFileDTO.setFileName(fileName);
				bankBookFileDTO.setOriginalName(multipartFile.getOriginalFilename());

				result = bankBookDAO.setFile(bankBookFileDTO);
			
		}

		return result;

	}

	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setUpdate(bankBookDTO);
	}

	public int setDelete(Long num) throws Exception {
		return bankBookDAO.setDelete(num);
	}

}
