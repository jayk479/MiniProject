package com.yedam.app;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class MemberControl {
	int menu = 0;
	MemberService ms = new MemberService();
	BoardService bs = new BoardService();
	Scanner sc = new Scanner(System.in);
	
	public MemberControl() {
		job();
	}
	
	public void job() {
		while(true) {
			menu();
			if(MemberService.memberInfo.getGrade().equals("A")){
				if(menu == 1) {
					ms.getMemberList();
				}else if(menu == 2) {
					ms.updateMemberGrade();
				}else if(menu == 3) {
					new BoardControl();
				}else if(menu == 99) {
					ms.logout();
					new Application();
				}
			}else if(MemberService.memberInfo.getGrade().equals("BS")) {
				if(menu == 1) {
					
				}else if(menu == 2) {
					
				}else if(menu == 3) {
					
				}else if(menu == 4) {
					
				}else if(menu == 99) {
					ms.logout();
					new Application();
			}else if(MemberService.memberInfo.getGrade().equals("NS")) {
				if(menu == 1) {
					ms.logout();			
				}else if(menu == 99) {
					ms.logout();
					new Application();
					
				}
				}
			}
		}
		
	}
	
	private void menu() {
		if(MemberService.memberInfo.getGrade().equals("A")) {
			System.out.println("1. 회원조회 | 2. 회원등급수정 | 3. 공지사항 | 99. 로그아웃");
			//System.out.println(MemberService.memberInfo.getGrade());
		}else if(MemberService.memberInfo.getGrade().equals("BS")) {
			System.out.println("1. 예약하기 | 2. 예약확인 | 3. 예약수정 | 4. 개인정보수정 | 99. 로그아웃");
		}else if(MemberService.memberInfo.getGrade().equals("NS")) {
			System.out.println("1. 공지사항읽기 | 99. 로그아웃");
		}
		System.out.println("입력> ");
		menu = Integer.parseInt(sc.nextLine());
	}

}
