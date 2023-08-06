package com.iu.main.bookAccount;

import java.sql.Date;

import com.iu.main.util.Pager;

public class BookAccountDTO {

	private Long accountNum;
	private String id;
	private String bookNum;
	private String account;
	private Long accountPw;
	private Long accountBalance;
	private Date accountDate;
	
	
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Long getAccountPw() {
		return accountPw;
	}
	public void setAccountPw(Long accountPw) {
		this.accountPw = accountPw;
	}
	public Long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	
	
	
}
