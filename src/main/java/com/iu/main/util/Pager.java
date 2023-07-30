package com.iu.main.util;

public class Pager {
	
	private Long startRow;
	private Long lastRow;
	private Long page;
	private Long perPage;
	private Long totalPage;
	
	public void makePageNum() {
		 page = totalPage/perPage;
		 if(totalPage%perPage!=0) {
			 page++;
		 }
		 
	}
	public void makeRowNum() {
		 startRow = 1+(page-1)*perPage;
		 lastRow = page*perPage;
	}
	
	
	
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getPage() {
		if(this.page==0) {
		   page = 1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getPerPage() {
		if(this.perPage==0) {
		   perPage = 10L;
		}
		return perPage;
	}
	
	
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	
	
	
	
	
	

}
