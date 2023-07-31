package com.iu.main.board;

import java.sql.Date;
import java.util.List;

import com.iu.main.member.MemberDTO;

public class BoardDTO {
	
	private Long boardNum;
    private String boardWriter;
    private String boardName;
    private Integer boardHit;
    private Date boardDate;
    private String boardContents;
    private String id;
	private List<BoardFileDTO> boardFileDTOs;
    
    
	
	
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}
	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}
	
    
	
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public Integer getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(Integer boardHit) {
		this.boardHit = boardHit;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	
    
    
    
}
