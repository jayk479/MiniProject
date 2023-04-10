package com.yedam.app;

import java.util.Scanner;

import com.yedam.board.BoardService;

public class Board {
	BoardService bs = new BoardService();
	Scanner sc = new Scanner(System.in);
	int menu = 0;
	
	public Board() {
		job();
	}
	
	public void job() {
		while(true) {
		System.out.println("1. 공지사항읽기 | 2. 공지사항수정 | 3. 공지사항작성 | 4. 공지사항삭제 | 5. 돌아가기");
		System.out.println("입력> ");
		menu = Integer.parseInt(sc.nextLine());			
			if(menu == 1) {
				//공지사항읽기
				 bs.getBoardList();
			}else if(menu == 2) {
				
				
			}else if(menu == 3) {
				
				
			}else if(menu == 4) {
				
				
			}else if(menu == 5) {
				// 돌아가기
				break;
			}
			
			
			
		}
	}
}
