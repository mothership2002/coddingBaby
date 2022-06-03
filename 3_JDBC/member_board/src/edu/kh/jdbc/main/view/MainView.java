package edu.kh.jdbc.main.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.board.view.BoardView;
import edu.kh.jdbc.member.model.vo.Member;
import edu.kh.jdbc.member.view.MemberView;

public class MainView {
	
	private Scanner sc = new Scanner(System.in);
	private Member loginMember; 
	private MemberView memberView = new MemberView();
	private BoardView boardView = new BoardView();
	
	/**
	 * 메인 디스플레이 
	 */
	public void displayMenu() {
		int menuNum = -1;
		
		do {
			try {
				if(loginMember == null) { // 로그인 페이지
					System.out.println("\n******** 게시판 프로그램 ********\n");
					
					System.out.println("1. 로그인");
					System.out.println("2. 회원가입");
					System.out.println("0. 프로그램 종료\n");
					
					System.out.print("매뉴 선택 > ");
					menuNum = sc.nextInt();
					sc.nextLine();
					
					switch(menuNum) {
					case 1: System.out.println();
							loginMember = memberView.login();
						break;
					case 2: System.out.println();
							memberView.signUp();
						break;
					case 0: System.out.println("\n프로그램 종료.");
						break;
					default : System.out.println("\n메뉴에 해당하는 번호만 입력해주세요.");
					}
					
				}else { // 성공 페이지
					System.out.println("******* 회원 메뉴 *******\n");
					System.out.println("1. 내 정보 조회");
					System.out.println("2. 가입된 회원 정보 조회");
					System.out.println("3. 내 정보 수정 "); //이름성별
					System.out.println("4. 비밀번호 수정 ");
					System.out.println("5. 회원 탈퇴");
					System.out.println("6. 게시판 메뉴로 들어가기");
					System.out.println("9. 로그아웃 \n");
					
					System.out.print("메뉴 선택 : ");
					menuNum = sc.nextInt();
					sc.nextLine();
					switch(menuNum) {
					case 1 : memberView.myInfo(loginMember);
						break;
					case 2 : memberView.selectAll();
						break;
					case 3 : memberView.updateMyInfo(loginMember);
						break;
					case 4 : memberView.updatePass(loginMember);
						break;
					case 5 : loginMember = memberView.secessionY(loginMember);
						break;
					case 6 : boardView.boardMenu(loginMember);
						break;
					case 9 : loginMember = null;
							 System.out.println("\n로그아웃이 완료 되었습니다.");
						break;
					case 0 : menuNum = -10;
					default : System.out.println("\n메뉴에 해당되는 문자를 입력해주세요.\n");	
					}
				}
			}catch(InputMismatchException e) {
				System.out.println("\n입력 값이 옳바르지 않습니다.");
				sc.nextLine();
			}
		}while(menuNum != 0);
		
	}
	
}