package com.iu.main.member;

import java.sql.Date;

import org.springframework.stereotype.Repository;

public class MemberDTO {
	//접근지정자는 private
	//변수명 타입은 Table의 컬럼과 동일하게
	//setter, getter
	//생성자는 여러개 선언 가능하지만, 기본 생성자는 필수
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private Date birth;
	private MemberFileDTO memberFileDTO;
	
	
	public MemberFileDTO getMemberFileDTO() {
		return memberFileDTO;
	}
	public void setMemberFileDTO(MemberFileDTO memberFileDTO) {
		this.memberFileDTO = memberFileDTO;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	
	
	

}
