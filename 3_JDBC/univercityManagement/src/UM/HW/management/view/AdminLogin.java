package UM.HW.management.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import UM.HW.management.model.service.DataService;
import UM.HW.management.model.vo.LogVo;
import UM.HW.management.model.vo.ValueObject;

public class AdminLogin {
	
	private Scanner sc = new Scanner(System.in);
	private DataService ds = new DataService();

	public void login() {
		int cycle = -10;
		int result;
		
		try {
			System.out.println("\n1. 관리자 계정 로그인\n");
			
			do {
				System.out.print("아이디 : ");
				String id = sc.next();
				System.out.print("패스 워드 : ");
				String pw = sc.next();
				LogVo login = new LogVo(id, pw);
				
				result = ds.loginAdmin(login);
				
				if(result == 1) {
					System.out.println("\n로그인이 완료되었습니다.\n");
					login = null;
					adminView();
					result = 0;
					cycle = 1;
				}else {
					System.out.println("\n아이디 또는 비밀번호가 일치하지 않습니다.\n");
				}
			}while(cycle != 1);	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void adminView() {
		int menuNum;
		try {
			do {
				System.out.println("\n관리자 메뉴\n");
				System.out.println("1. 학생 삽입");
				System.out.println("2. 교수 계정 접근 권환 변경 대상자");
				System.out.println("3. 학생 학년 최신화");
				System.out.println("\n0. 로그아웃\n");
				System.out.print("메뉴 입력 : ");
				menuNum = sc.nextInt();
				sc.nextLine();
				switch(menuNum) {
				case 1 : insertStudent();
					break ;
				case 2 : proAccessCheck();
					break ; 
				case 3 : gradeUpdate();
					break ;
				case 0 : System.out.println("\n로그아웃 합니다.\n");
					break;
				default : System.out.println("\n해당 메뉴는 존재하지 않습니다.\n");
				}
			}while(menuNum != 0);
		}catch(InputMismatchException e) {
			System.out.println("\n숫자만 입력 해주세요.\n");
		}
		
	}


	private void insertStudent() {
		try {
			System.out.println("\n1. 학생 삽입");
			ArrayList<ValueObject> insertStudents = new ArrayList<ValueObject>();
			while(true) {
				
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("주민번호(-포함) : ");
				String ssn = sc.next();
				System.out.print("핸드폰(-포함) : ");
				String phone = sc.next();
				System.out.print("이메일 : ");
				String email = sc.next();
				System.out.print("학과 : ");
				String dept = sc.next();
				sc.nextLine();
				System.out.print("주소 : ");
				String adress = sc.nextLine();
				System.out.print("입학년도(yyyyMMdd) : ");
				String amissonString = sc.next();
				
				//학번 생성
				char indexOne = amissonString.charAt(2);
				char indexTwo = amissonString.charAt(3);
				String sdnSet =  String.valueOf(indexOne)
								+String.valueOf(indexTwo)
								+String.valueOf("00000");
				String studentNo = null;
				boolean flag = true;
				//중복검사	
				while(flag) {

					int sdnInt = Integer.parseInt(sdnSet) + (int)(Math.random()*100000);
					studentNo = String.valueOf(sdnInt);
					
					for(ValueObject vo : insertStudents) {
						if(!vo.getStudentNo().equals(studentNo)) {
							flag = false;
						}
					}
					if(ds.dpcStudentNo(studentNo)>0) flag = true;
					else flag = false;
				}
				
				//날짜 형변환
				String dateFormat = 
						 amissonString.substring(0,4)
						+"-"
						+amissonString.substring(4,6)
						+"-"
						+amissonString.substring(6,7);
				
				ValueObject studentInfo = new ValueObject(studentNo, name, ssn, phone, email, adress, 0, dept, dateFormat);
				
				insertStudents.add(studentInfo);
				
				System.out.print("\n더 추가 하시겠습니까? (Y/N) : ");
				char ans = sc.next().toUpperCase().charAt(0);
				if(ans != 'Y') break;
			}
			int result = ds.insertStudents(insertStudents);
			if(result > 0) System.out.println("\n"+result + "명의 학생이 저장되었습니다.\n");
			else		   System.out.println("실패");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void proAccessCheck() {
		System.out.println("\n2. 교수 계정 접근 권한 부여 대상자");
		try { 
			List<ValueObject> PAAC = ds.PAAC();
			int select = 0;
			for(ValueObject vo : PAAC) {
				System.out.printf("계정 번호 : %d | 교수 성명 : %s | 교수 부서 : %s |\n",
						           vo.getAccountNo(),vo.getProName(),vo.getDepartMentName());
				select++;
			}
			if(select !=0) {
				System.out.println("\n1. 모든 계정 권한 변경");
				System.out.println("2. 계정 선택 권한 변경");
				System.out.println("\n0. 이전 메뉴로");
				System.out.print("\n메뉴 선택 : ");
				int menuNum = sc.nextInt();
				sc.nextLine();
				switch(menuNum) {
				case 1:	
					System.out.println("\n해당 모든 계정의 변경 권한을 부여 하시겠습니까? (Y/N)");
					int result = 0;
					if( sc.next().toUpperCase().charAt(0) == 'Y' ) {
						for(ValueObject vo : PAAC) {
							if(ds.accessY(vo.getAccountNo()) > 0)result++;
						}
						System.out.println("\n"+result +"개의 계정의 권한이 변경되었습니다.\n");
					}
					else 	System.out.println("\n변경이 취소 되었습니다.");
					break;
				case 2: 
					System.out.print("\n계정 번호를 입력해주세요 : ");
					int choiceNum = sc.nextInt();
					if(choiceNum > 0) {
						ValueObject accountNo = new ValueObject();
						accountNo.setAccountNo(choiceNum);
						ValueObject responde = ds.accountCheck(accountNo);
						if(!responde.equals(null) ) {
							System.out.println("\n"+responde.getProName()+" 교수님의 권한이 변경되었습니다.");
						}else {
							System.out.println("\n해당 값이 옳바르지 않습니다.");
						}
					}
					break;
				case 0:System.out.println("\n이전 메뉴로 돌아갑니다.\n");
					break;
				default :
				}

			}else {
				System.out.println("\n모든 계정이 권한을 갖고 있습니다.");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void gradeUpdate() {
		try {
			System.out.println("\n3. 학년 최신화");
			System.out.println("\n모든 학생의 학년을 최신화 합니다.");
			int result = ds.updateGrade();
			if(result > 0)
			System.out.println("\n"+result +"명의 학생의 학년을 최신화 하였습니다.\n");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
}
