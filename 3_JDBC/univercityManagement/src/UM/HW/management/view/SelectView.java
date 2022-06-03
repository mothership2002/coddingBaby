package UM.HW.management.view;


import java.util.List;
import java.util.Scanner;

import UM.HW.management.model.service.DataService;
import UM.HW.management.model.vo.ValueObject;

public class SelectView {
	
	private Scanner sc = new Scanner(System.in);
	private DataService service = new DataService();
	
	public void selectStudent() {
		try {
			
			System.out.println("\n1. 학과생 검색\n");
			System.out.print("학과명 : ");
			String departmentName = sc.next();
			List<ValueObject> result = service.selectStudent(departmentName);
			
			if(result.isEmpty()) System.out.println("\n해당 학과는 학과생이 없습니다.\n");
			else {
				System.out.println();
				for(ValueObject e : result) {
					System.out.printf("학번 : %6s | 이름 : %5s | 학년 : %d학년 | 입학일자 : %8s | 나이 : %d | 핸드폰 번호 : %14s | 이메일 : %15s | 주소 : %s \n"
									,e.getStudentNo(),e.getStudentName(),e.getStudentGrade(),e.getAdmission(),e.getStudentAge(),e.getStudentPhone(),e.getStudentEmail(),
									e.getStudentAdress());
				}
			}
			System.out.println();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void selectRecord() {
		try {
			System.out.println("\n2. 학생 성적 확인\n");
			System.out.print("학생 이름 : ");
			String studentName = sc.next();
			System.out.print("학번 : ");
			String studentNo = sc.next();
			List<ValueObject> studendGrade = service.selectGrade(studentName,studentNo);
			
			if(studendGrade.isEmpty()) System.out.println(studentName + " 학생의 성적이 등록되지 않았거나.\n" );
			else {
				System.out.println();
				System.out.println(studentName + " 학생의 과목 성적\n");
				for(ValueObject e : studendGrade) {
					System.out.printf("과목 : %s  성적 : %.1f  \n",e.getClassName(),e.getStudenRecord());
				}
			}
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	//학생 조회 기능
	
	public void selectProfessor() {
		try {
			System.out.println("\n1. 해당 학과 교수 조회\n");
			System.out.print("학과명 : ");
			String departmentName = sc.next();
			List<ValueObject> result = service.selectProfessor(departmentName);
			
			if(result.isEmpty()) System.out.println("\n해당 학과는 교수님이 없습니다.\n");
			else {
				for(ValueObject e : result) {
					System.out.printf("이름 : %5s | 나이 : %s  \n"
									,e.getProName(),e.getProAge());
				}
			}
			System.out.println();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void selectMessenger() {
		try {
			System.out.println("\n2. 교수 연락처 조회\n");
			System.out.print("소속 학과 : ");
			String proDept = sc.next();
			System.out.print("교수 성명 : ");
			String proName = sc.next();
			List<ValueObject> proMess = service.selectMessenger(proDept,proName);
			
			if(proMess.isEmpty()) System.out.println("\n해당 성함의 교수님 해당 학과에 계시지 않습니다.\n");
			else {
				System.out.println();
				for(ValueObject e : proMess) {
					System.out.printf("성함 : %s | 핸드폰 : %s | 이메일 : %s  \n",proName,e.getProPhone(),e.getProEmail());
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
