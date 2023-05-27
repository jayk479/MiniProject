package com.yedam.board;

import java.sql.Date;

public class Board {
	private int indexNo;
	private String title;
	private String content;
	private int memberId;
	private String memberName;
	private Date writeDate;
	public int getIndexNo() {
		return indexNo;
	}
	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	

}
