package com.iu.main.bankBook.bankBookQna;

import java.sql.Date;

import com.iu.main.board.qna.QnaDTO;

public class BookQnaDTO{

	private Long boardNum;
	private String writer;
	private Long bookNum;	
	private String boardContents;
	private Date boardDate;
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	

	

}
