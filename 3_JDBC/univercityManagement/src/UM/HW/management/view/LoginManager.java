package UM.HW.management.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import UM.HW.management.model.vo.LogVo;

public class LoginManager {

	private Scanner sc = new Scanner(System.in);
	private LogVo login;
	private LoginView loginView = new LoginView();
	private AdminLogin al = new AdminLogin();
	
	public void professorLogin() {
		int menuNum = 10;
		do {
			try {
				if(login == null) {
					System.out.println("\n[ 교수 전용 메뉴 ] \n");
					System.out.println("1. 교수 계정 로그인");
					System.out.println("2. 교수 계정 등록");
					System.out.println("\n0. 이전 메뉴로");
					System.out.print("\n메뉴 선택 : ");
					menuNum = sc.nextInt();
					sc.nextLine();
					switch(menuNum) {
					case 1 : loginView.login();
						break; 
					case 2 : loginView.addAccount();
						break;
					case 0 : System.out.println("\n이전 메뉴로 돌아갑니다.");
						break;
					default : System.out.println("\n해당 숫자에 해당하는 메뉴가 없습니다.");
					}
				}
			}catch(InputMismatchException e) {
				System.out.println("\n옳바른 값이 아닙니다. 다시 시도해주세요");
				sc.nextLine();
			}catch(Exception e ) {
				e.printStackTrace();
			}
		}while(menuNum != 0 );
		
	}
	
	//관리자용 흠..
	public void managerLogin() {
		int menuNum = -10;
		do {
			try {
				System.out.println("\n[ 관리자 메뉴 ] \n");
				System.out.println("1. 관리자 로그인");
				System.out.println("\n0. 이전 메뉴로");
				System.out.print("\n메뉴 선택 : ");
				menuNum = sc.nextInt();
				sc.nextLine();
				switch(menuNum) {
				case 1 : al.login();
					break;
				case 0 : System.out.println("\n이전 메뉴로 돌아갑니다.");
					break;
				default : System.out.println("\n해당 숫자에 해당하는 메뉴가 없습니다.");
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("\n옳바른 값이 아닙니다. 다시 시도해주세요");
				sc.nextLine();
			}catch(Exception e ) {
				e.printStackTrace();
			}
		}while(menuNum != 0);
	}

}
