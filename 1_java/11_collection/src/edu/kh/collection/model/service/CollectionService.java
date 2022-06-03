package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Student;


public class CollectionService {
	
	private Scanner sc = new Scanner(System.in);
	private List<Student> studentList = new LinkedList<Student>(); //기본크기 10칸 배열
//  추가 삭제 특화 
//	private List<Student> studentList = new ArrayList<Student>(); -검색 특화

	//arraylist(크기)
	//arraylist : java.util.arraylist - list 자식개체 - list는 칸 조절 가능
	
//	public void ex() {
//		//list test
//		studentList.add(new Student());
//		
//		{Object List.get(index i): }
//		
//		System.out.println(studentList.get(0).toString());
//	
//		if(studentList.get(0) instanceof Student) {
//			System.out.println(((Student)studentList.get(0)).getName());
//		}//- 일반적인 코딩 (제네릭X)
//		
//		System.out.println(studentList.get(0).getAge()); //-제네릭스
//		
//	}
//	
	
	public CollectionService() {
		
		studentList.add(new Student("홍길동", 25, "서울시 중구", 'M', 90));
		studentList.add(new Student("고영희", 23, "경기도 안산시", 'F', 100));
		studentList.add(new Student("김아지", 30, "서울시 강남구", 'M', 80));
		studentList.add(new Student("오미나", 27, "충북 청주시", 'F', 90));
		studentList.add(new Student("박주희", 24, "서울 서대문구", 'F', 70));
		studentList.add(new Student("아리랑", 24, "부산시 동래구", 'F', 70));
		
	}

	
	/** 
	 * 메뉴 출력용 메소드
	 * @author 임동현
	 */
	public void displayMenu() {
		
		int menuNum = 0 ;
		
		do {
			
			System.out.println("\n===== 학생 관리 프로그램 =====\n");
		
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 삭제");
			System.out.println("5. 이름으로 검색");
			System.out.println("6. 단어로 검색");
			System.out.println("\n0. 프로그램 종료");
			
			System.out.print("\n메뉴 번호 : ");
			try{
				menuNum = sc.nextInt();
				
				switch (menuNum) {
				case 1: System.out.println(addStudent());
					break;
				case 2: selectAll();
					break;
				case 3: System.out.println(updateMember());
					break;
				case 4: System.out.println(removeMember());
					break;
				case 5: searchName1();
					break;
				case 6: searchName2();
					break;
				case 0: System.out.println("\n프로그램을 종료합니다.");
					break;
				default: System.out.println("\n해당 번호는 메뉴가 존재하지 않습니다. \n다시 입력해 주세요");
				}
				
			}catch(InputMismatchException e ) {
				System.err.println("\n입력 형식이 유효하지 않습니다.\n다시 시도해주세요");
				sc.nextLine();
				menuNum = 10;
			}catch(IndexOutOfBoundsException e) {
				System.err.println("\n해당 숫자의 학생이 등록되지 않았습니다.");
			}

		}while(menuNum!=0);
		System.out.println();

		
	}
	
	public String addStudent() throws InputMismatchException {
		
		System.out.println("\n===== 학생 정보 추가 =====\n");
		
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();					sc.nextLine();
		System.out.print("사는 곳 : ");
		String region = sc.nextLine();
		System.out.print("성별 (M/F) : ");
		char gender = sc.nextLine().toUpperCase().charAt(0);
		System.out.print("점수 : ");
		int score = sc.nextInt();				sc.nextLine();
		
		if(studentList.add(new Student(name, age, region, gender, score))) {
			return "성공";
			//add()는 항상 true
		}else {
			return "실패";
		}

		
	}
	
	/** 오 ㅋ
	 *  alt shift j
	 */
	public void selectAll() {
		System.out.println();
////	if(studentList.size()==0) {	
//		if(studentList.isEmpty()) {
//			System.out.println("현재 학생 정보가 등록되어 있지 않습니다.");
//			return;
//		}
//		
//		for(int i=0;i<studentList.size();i++) {
//			System.out.println(studentList.get(i));
//		}
		//for each{}
		int index = 0;
		for(Student std:studentList) {
			System.out.print((++index) + "번 : ");
			System.out.println(std);
		}
	}
	
	public String updateMember() throws InputMismatchException,IndexOutOfBoundsException {
		
		System.out.println("\n===== 학생 정보 수정 =====\n");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		index--;
		sc.nextLine();
		
		if(studentList.isEmpty()) {
			return "\n등록 된 학생 정보가 없습니다.";
		}else if(index<0) {
			return "\n음수는 존재하지 않습니다.";
		}else if(index>studentList.size()) {
			return "\n범위를 넘어선 값은 입력할 수 없습니다.";
		}else {
			System.out.println(++index + "번에 저장된 학생 정보 ");
			System.out.println(studentList.get(--index));
			
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("나이 : ");
			int age = sc.nextInt();					sc.nextLine();
			System.out.print("사는 곳 : ");
			String region = sc.nextLine();
			System.out.print("성별 (M/F) : ");
			char gender = sc.nextLine().charAt(0);
			System.out.print("점수 : ");
			int score = sc.nextInt();				sc.nextLine();
			
			new Student(name, age, region, gender, score);
			Student lastStudent = 
					studentList.set(index, new Student(name, age, region, gender, score));
			
			return lastStudent.getName() + "학생의 정보가 변경되었습니다. \n";
			
		}
		
	
	}
	
	public String removeMember() throws IndexOutOfBoundsException {
	
		System.out.println("\n===== 학생 정보 제거 =====\n");
		
		System.out.print("제거 할 인덱스 번호 입력 : ");
		int index = sc.nextInt();
		index--;
		sc.nextLine();
		
		if(studentList.isEmpty()) {
			return "\n등록 된 학생 정보가 없습니다.";
		}else if(index<0) {
			return "\n음수는 존재하지 않습니다.";
		}else if(index>studentList.size()) {
			return "\n범위를 넘어선 값은 입력할 수 없습니다.";
		}else {
			System.err.print("\n삭제하시겠습니까? (Y/N) : ");
			char delet = sc.next().toUpperCase().charAt(0);
			if(delet == 'Y') {
				Student last = studentList.remove(index);
				return "\n" + last.getName() + "학생의 정보가 삭제되었습니다.";
			}else {
				return "\n취소되었습니다.";
			}
			
		}
		
	}
	
	public void searchName1() {
		
		System.out.println("\n===== 학생 검색 (이름 일치) =====\n");
		
		System.out.print("학생 이름 입력 : " );
		String input = sc.next();
		boolean flag = true;
		System.out.println();
		
		for(Student std : studentList) {
			if(input.equals(std.getName())) {
				System.out.println(std);
				flag = false;
			}
		}
		if(flag) {
			System.out.println("\n해당 학생은 입력 되어있지 않습니다.");
		}
	}

	public void searchName2() {
		System.out.println("\n===== 학생 검색 (이름 포함) =====\n");
		
		System.out.print("포함 문자열 입력 : " );
		String input = sc.next();
		boolean flag = true;
		System.out.println();
		
		for(Student std : studentList) {
			if(std.getName().contains(input)) {
				System.out.println(std);
				flag = false;
			}
		}
		if(flag) {
			System.out.println("\n해당 학생은 입력 되어있지 않습니다.");
		}
	}
		
	
	
	
}
