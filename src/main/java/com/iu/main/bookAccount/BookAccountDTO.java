package com.iu.main.bookAccount;

import java.sql.Date;

import com.iu.main.util.Pager;

public class BookAccountDTO {

	private Long accountNum;
	private String id;
	private Long bookNum;
	private Long account;
	private String accountPassword;
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
	
	
	
	
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public Long getAccount() {
		return account;
	}
	public void setAccount(Long account) {
		this.account = account;
	}
	
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	
	public Long getAccountBalance() {
		if(this.accountBalance==null) {
		   accountBalance = 0L;
		}
			return accountBalance;
		
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	
	
	
}
