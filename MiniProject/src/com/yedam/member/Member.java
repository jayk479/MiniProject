package com.yedam.member;

import java.sql.Date;

import lombok.Data;

@Data
public class Member {

	private int memberId;
	private String memberName;
	private Date birth;
	private int departmentId;
	private String departmentName;
	private String mail;
	private String address;
	private String phone;
	private String grade;
	private String id;
	private String pw;
}
