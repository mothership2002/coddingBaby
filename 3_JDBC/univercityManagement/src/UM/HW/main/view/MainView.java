package UM.HW.main.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import UM.HW.management.view.LoginManager;
import UM.HW.management.view.SelectView;

public class MainView {
	
	private Scanner sc = new Scanner(System.in);
	private LoginManager loginManager = new LoginManager();
	private SelectView selectView = new SelectView();
	
	public void displayMenu(){	
		int choice = -10;
		do {
			try {
				System.out.println("\n [ 학부 관리 시스템 ] 0.1 ver \n");
				System.out.println("1. 학생 정보 조회 ");
				System.out.println("2. 교수 정보 조회");
				System.out.println("3. 교수 전용 메뉴");
				System.out.println("4. 관리자 전용 메뉴");
				System.out.println();
				System.out.println("0. 프로그램 종료");
				
				System.out.print("\n메뉴 선택 : ");
				choice = sc.nextInt();
				sc.nextLine();
					
				switch(choice) {
				case 1 : System.out.println();
					selectStudent();
					break;
				case 2 : System.out.println();
					selectprofessor();
					break;
				case 3 : System.out.println();
					loginManager.professorLogin();
					break;
				case 4 : System.out.println();
					loginManager.managerLogin(); 
					break;
				case 0 : System.out.println("\n프로그램을 종료합니다.\n");
					break;	
				default : System.out.println("\n 메뉴에 알맞는 숫자가 아닙니다.\n");
					}
			}catch(InputMismatchException e) {
				System.out.println("\n 문자를 입력하셨습니다. 다시 입력해주세요\n");
				sc.nextLine();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}while(choice != 0);
	}
	
	public void selectStudent() {
		int menuNum = -10;
		do {
			try {
				System.out.println("\n [ 학생 정보 조회 ] \n");
				System.out.println("1. 학과생 조회");
				System.out.println("2. 학생 성적 조회");
//				System.out.println("3. 장학금 대상자 조회");
				System.out.println("\n0. 이전 메뉴로");
				
				System.out.print("\n메뉴 입력 : ");
				menuNum = sc.nextInt();
				sc.nextLine();
				
				switch(menuNum) {
				case 1 : selectView.selectStudent();
					break;
				case 2 : selectView.selectRecord();
					break;
//				case 3 : 
//					break;
				case 0 : System.out.println("\n이전 메뉴로 이동합니다. \n");
					break;
				default : System.out.println("\n 해당 메뉴는 존재하지 않습니다.\n");	
				}
			}catch(InputMismatchException e) {
				System.out.println("\n 문자로 잘못 입력하셨습니다. 다시 시도 하십시오.\n");
				sc.nextLine();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}while(menuNum != 0);
	}

	public void selectprofessor() {
		int menuNum = -10;
		do {
			try {
				System.out.println("\n [ 교수 정보 조회 ]\n");
				System.out.println("1. 해당 학과 교수 조회");
				System.out.println("2. 교수 연락처 조회");
				System.out.println("\n0. 이전 메뉴로 ");
				
				System.out.print("\n메뉴 입력 : ");
				menuNum = sc.nextInt();
				sc.nextLine();

				switch(menuNum) {
				case 1 : selectView.selectProfessor();
					break;
				case 2 : selectView.selectMessenger();
					break;
				case 0 : System.out.println("\n이전 메뉴로 이동합니다. \n");
					break;
				default : System.out.println("\n 해당 메뉴는 존재하지 않습니다.\n");	
				}
			}catch(InputMismatchException e) {
				System.out.println("\n 문자로 잘못 입력하셨습니다. 다시 시도 하십시오.");
				sc.nextLine();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}while(menuNum != 0);
		
	}

}

