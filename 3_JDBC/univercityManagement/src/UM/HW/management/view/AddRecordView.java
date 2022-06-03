package UM.HW.management.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import UM.HW.management.model.service.DataService;
import UM.HW.management.model.vo.LogVo;
import UM.HW.management.model.vo.ValueObject;

public class AddRecordView {
	
	private Scanner sc = new Scanner(System.in);
	private DataService ds = new DataService();
	private SelectView sv = new SelectView();
	
	public void proDisplay(LogVo result) {
		int menuNum;
		try {
			do {
				System.out.println("\n [ 교수 계정 로그인 메뉴 ]\n");
				System.out.println("1. 학생 성적 등록");
				System.out.println("2. 학생 조회");
				System.out.println("3. 학생 성적 조회");
				System.out.println("\n0. 로그아웃\n");
				System.out.print("메뉴 입력 : ");
				menuNum = sc.nextInt();
				sc.nextLine();
				switch(menuNum) {
				case 1 : recordGrade(result);
					break;
				case 2 : sv.selectStudent();
					break;
				case 3 : sv.selectRecord();
					break;
				case 0 : System.out.println("\n이전 메뉴로 돌아갑니다.\n");
					break;
				default: System.out.println("\n해당 숫자에 해당하는 메뉴가 없습니다.\n");
				}
			}while(menuNum != 0);
		}catch(InputMismatchException e) {
			System.out.println("\n입력값이 옳바르지 않습니다. 다시 시도 해주세요\n");
			sc.nextLine();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void recordGrade(LogVo result) {
		System.out.println("\n1. 학생 성적 등록 \n");
		System.out.println("학적 변경 권한이 있는지 확인합니다.\n");
		try {
			char asc = result.getAccess_YN();
			if(asc == 'Y') {
				System.out.println("권한이 확인 되었습니다. \n");
				String studentNo;
				String studentName;	
				while(true)	{
					System.out.print("학번 : ");
					studentNo = sc.next();
					System.out.print("학생 이름 : ");
					studentName = sc.next();
					
					ValueObject check = new ValueObject();
					check.setStudentNo(studentNo);
					check.setStudentName(studentName);
					
					int a = ds.checkStudent(check);
					if(a == 1) {
						System.out.print("과목 입력 : ");
						String className = sc.next();
						check.setClassName(className);
						System.out.println("성적 입력 : ");
						double grade = sc.nextDouble();
						sc.nextLine();
						check.setStudenRecord(grade);
						
						int b = ds.insertRecode(check);
						if(b>0) {
							System.out.println("\n성적이 등록 되었습니다.");
							break;
						}
					}
					else System.out.println("\n해당 학생은 등록되지 않았습니다.\n");
				}
				
			}else {
				System.out.println("\n접근 권한이 부여되지 않았습니다. 관리자에게 문의하세요.\n");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}	
		

}
