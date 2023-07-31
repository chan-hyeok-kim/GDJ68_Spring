package com.iu.main.board.notice;

import java.sql.Date;
import java.util.List;

import com.iu.main.board.BoardDTO;
import com.iu.main.member.MemberDTO;

public class NoticeDTO extends BoardDTO {
	
    private String id;
	private List<NoticeFileDTO> noticeFileDTOs;
    
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<NoticeFileDTO> getNoticeFileDTOs() {
		return noticeFileDTOs;
	}
	public void setNoticeFileDTOs(List<NoticeFileDTO> noticeFileDTOs) {
		this.noticeFileDTOs = noticeFileDTOs;
	}
	
    
    
    
}