package com.iu.main.member;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	

	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	public int setJoin(MemberDTO memberDTO, MultipartFile multipartFile, HttpSession session) throws Exception{
		//파일의 정보를 이용해서 HDD에 파일을 저장
		
		//1. 어디에 저장??
		String path ="/resources/upload/member/";
		
		//2. 실제 경로 알아오기
		//jsp: application이라고 부르지만
		//java: ServletContext이다
		String realPath = session.getServletContext().getRealPath(path);
		System.out.println(realPath);
		
		File file = new File(realPath);
//		경로가 없어도 일단 파일 객체는 만들어짐
		if(!file.exists()) {
			file.mkdirs();
		}
		
		Calendar ca = Calendar.getInstance();
		long result = ca.getTimeInMillis();
		
		file = new File(file, result+"_"+multipartFile.getOriginalFilename());
		
//		3. 파일을 저장하는 법 2개
//		A. Spring에서 제공하는 API. FileCopyUtils메서드
//		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
//		B. MultipartFile의 transferTo메서드
		multipartFile.transferTo(file);
		
		
//		dest은 목적지 의미
		
		
		return 0;// memberDAO.setJoin(memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.setMemberUpdate(memberDTO);
	}

}
