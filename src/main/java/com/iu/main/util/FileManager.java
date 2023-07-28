package com.iu.main.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	
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
	
	

}
