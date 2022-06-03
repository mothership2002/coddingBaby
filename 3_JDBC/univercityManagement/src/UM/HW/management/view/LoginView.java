package UM.HW.management.view;

import java.util.Scanner;

import UM.HW.management.model.service.DataService;
import UM.HW.management.model.vo.LogVo;

public class LoginView {
	
	private Scanner sc = new Scanner(System.in);
	private DataService ds = new DataService();
	private AddRecordView arv = new AddRecordView();

	public void addAccount() {
		try {
			System.out.println("\n2. 교수 계정 등록\n");
			String id;
			while(true) {
				System.out.print("아이디 : ");
				id = sc.next();
				if(ds.duplicateCheck(id) == 1) {
					System.out.println("\n중복된 아이디가 존재합니다. \n");
				}
				else {
					System.out.println("\n사용 가능한 아이디입니다.\n");
					break;
				}
			}
			String pw;
			while(true) {
				System.out.print("패스워드 : ");
				pw = sc.next();
				System.out.print("패스워드 확인 : ");
				String pwChk = sc.next();
				if(pw.equals(pwChk)) break;
				else   				 System.out.println("\n패스워드가 일치하지 않습니다.\n");
			}
			
			System.out.print("성함 : ");
			String name = sc.next();
			System.out.print("주민번호 : ");
			String ssn = sc.next();
			System.out.print("학과 : ");
			String dept = sc.next();
			
			LogVo check = new LogVo();
			check.setAccountName(name);
			check.setAccountSSN(ssn);
			check.setAccountDept(dept);
			
			if(ds.checkProfessor(check) == 1) {
				LogVo lv = new LogVo();
				lv.setAccountDept(dept);
				lv.setAccountId(id);
				lv.setAccountPw(pw);
				lv.setAccountName(name);
				lv.setAccountSSN(ssn);
				
				if(ds.addAccount(lv) == 1) {
					System.out.println("\n 계정 등록이 완료 되었습니다.\n");
				}else {
					System.out.println("\n 가입 실패");
				}
			}else {
				System.out.println("\n학교 교수 목록에 없습니다.\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void login() {
		int cycle = -10;
		LogVo result;
		try {
			System.out.println("\n1. 교수 계정 로그인\n");
			
			do {
				System.out.print("아이디 : ");
				String id = sc.next();
				System.out.print("패스 워드 : ");
				String pw = sc.next();
				LogVo login = new LogVo(id, pw);
				
				result = ds.login(login);
				
				if(result != null) {
					System.out.println("\n로그인이 완료되었습니다.\n");
					System.out.println("반갑습니다. "+result.getAccountName()+" 교수님.");
					cycle = 1;
					arv.proDisplay(result);
					login = null;
					result = null;
				}else {
					System.out.println("\n아이디 또는 비밀번호가 일치하지 않습니다.\n");
				}
			}while(cycle != 1);	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		
	}

}
