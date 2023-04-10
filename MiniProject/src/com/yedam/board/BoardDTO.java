package com.yedam.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private int titleNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
}
