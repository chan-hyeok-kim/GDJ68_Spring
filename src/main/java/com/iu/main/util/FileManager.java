package com.iu.main.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.main.file.FileDTO;

@Component
public class FileManager extends AbstractView {
	
	@Override
		protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
		   
		    String b = (String)model.get("board");
		    FileDTO fileDTO = (FileDTO)model.get("file");
			
//		    1. 파일 경로
		    String path = "/resources/upload/"+b;
		    path = request.getSession().getServletContext().getRealPath(path);
		    
//		    2. 파일 객체
		    File file = new File(path, fileDTO.getFileName());
//		    web.xml에 필터있으면 인코딩 안해줘도됨
		    
//		    3. 파일의 크기 설정
		    response.setContentLength((int)file.length());
		    
//		    4. 파일의 이름 인코딩(안 바꿔주면 UUID로 만든 긴 이름이 나오니까)
		    String downName = fileDTO.getOriginalName();
		    downName = URLEncoder.encode(downName,"UTF-8");
		    
//		    5. 헤더 정보 설정
			response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");
			response.setHeader("Content-Transfer-Encoding", "binary");

//			6. 전송
			FileInputStream is = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			FileCopyUtils.copy(is, os);
			
//			7. 자원 해제 - 연결했던 순서의 역순으로 끊어줌
			os.close();
			is.close();
		    
		    
		} 
	
//	fileSave
	public String fileSave(String path,MultipartFile multipartFile,HttpSession session) throws Exception {
		
		
		String realPath = session.getServletContext().getRealPath(path);
		File file = new File(realPath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String uId =UUID.randomUUID().toString();
		uId = uId+"_"+multipartFile.getOriginalFilename();
	    file = new File(file, uId);
		
	    multipartFile.transferTo(file);
	    
	    return uId;
	   
	}
	
	public boolean fileDelete(FileDTO fileDTO, String path, HttpSession session) {
		//1. 어디 폴더의 실제경로
		
	    path =  session.getServletContext().getRealPath(path);
	    System.out.println(path);
	    
	    File file = new File(path, fileDTO.getFileName());
	    
	    return file.delete();    
	}
	
	
	
	

}
