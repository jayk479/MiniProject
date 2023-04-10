package com.yedam.board;

import java.util.List;
import java.util.Scanner;

public class BoardService {
	
	Scanner sc = new Scanner(System.in);
	
	public void getBoardList() {
		List<BoardDTO> list = BoardDAO.getInstance().getBoardList();
		System.out.println("글번호\t제목\t내용\t\t\t\t\t작성자\t작성날짜");
		System.out.println("=========================================================================");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getTitleNo()+"\t");
			System.out.print(list.get(i).getTitle()+"\t");
			System.out.print(list.get(i).getContent()+"\t");
			System.out.print(list.get(i).getWriter()+"\t");
			System.out.print(list.get(i).getWriteDate()+"\n");
		}
	}
	
	public void updateBoard() {
		BoardDTO board = new BoardDTO();
		
		System.out.println("수정할글번호> ");
		int titleNo = Integer.parseInt(sc.nextLine());
		System.out.println();
	}
}
