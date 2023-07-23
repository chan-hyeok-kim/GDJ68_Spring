package com.iu.main.noticeBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeBoardService {
	
	@Autowired
	private NoticeBoardDAO noticeBoardDAO;

}
