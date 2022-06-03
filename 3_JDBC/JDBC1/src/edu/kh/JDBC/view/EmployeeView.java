package edu.kh.JDBC.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.JDBC.model.service.EmployeeService;
import edu.kh.JDBC.model.vo.Employee;

public class EmployeeView {
	
	private Scanner sc = new Scanner(System.in);
	
	private EmployeeService service = new EmployeeService();
	
	
	/**
	 * MainMenu
	 */
	public void displayMenu() {
		
		int menuNum = -1;
		
		do {
			try {
				
				System.out.println();
				System.out.println("====================================");
				System.out.println("[사원 관리 프로그램]");
				System.out.println("1. 전체 사원 정보 조회");
				System.out.println("2. 사번으로 사원 정보 조회");
				System.out.println("3. 새로운 사원 정보 추가");
				System.out.println("4. 사번으로 사원 정보 수정");
				System.out.println("5. 사번으로 사원 정보 삭제");
				System.out.println("6. 급여가 해당 금액 이상 직원 조회");
				System.out.println("7. 부서코드, 보너스 입력 수정");
				System.out.println("0. 프로그램 종료");
				System.out.println("====================================");
				
				System.out.print("메뉴 선택 : ");
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1: selectAll();
					break;
				case 2: selectOne();
					break;
				case 3: insertEmployee();
					break;
				case 4: updateEmployee();
					break;
				case 5: deleteEmployee();
					break;
				case 6: salaryOver();
					break;
				case 7:	updateBonus();
					break;
				case 0: System.out.println("프로그램을 종료합니다.");
					break;
				default : System.out.println("잘못 입력 하셨습니다. ");	
				}
				
			}catch(InputMismatchException e) {
				System.out.println("입력 형식이 옳바르지 않습니다.");
				sc.nextLine();
			}
			
		} while(menuNum != 0);
	}
	
	private void updateBonus() {
		
		System.out.println("[ 부서,보너스 수정 ]");
		System.out.print("부서 코드 입력 : ");
		String inputDC = sc.next();
		System.out.print("보너스 입력 : ");
		double inputBN = sc.nextDouble();
		sc.nextLine();
		
		Employee updateBn = new Employee();
		
		updateBn.setDeptCode(inputDC);
		updateBn.setBonus(inputBN);
		
		int result = service.updateBonus(updateBn);
		
		if(result > 0) {
			System.out.println("\n보너스가 변경");
		}else {
			System.out.println("\n실패");
		}
		
	}

	//1번
	public void selectAll() {
		System.out.println("[ 전체 사원 조회 ]");
		
		List<Employee> empList = service.selectAll();
		
		printList(empList);
	}
	
	/**
	 * 출력구문
	 */
	public void printList(List<Employee> empList) {
		
		// 1번
		if(empList.isEmpty()) {
			System.out.println("\n조회 결과 없음");	
		}else {
			for(Employee emp : empList) {
				System.out.println(emp);
			}
			
		}
		
	}
	
	//2 4 5 에 사용 할 입력 코드
	public int selectID() {
		System.out.print("사번 입력 : ");
		int emp_ID = sc.nextInt();
		sc.nextLine();
		return emp_ID;
	}
	
	// 2번
	public void selectOne() {
		System.out.println("[ 사번으로 조회 ]");
		int input = selectID();
		
		Employee emp = service.selectOne(input);
		
		List<Employee> emplList = new ArrayList<Employee>();
		
		if(emp != null) {
			emplList.add(emp);
		}
		printList(emplList);
	}
	
	// 문제 6
	public void salaryOver() {
		System.out.println("[ 급여가 해당 금액 이상 조회 ]");
		System.out.print("\n급여 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		List<Employee> salaryOverList = service.salaryOver(input);
		
		if(salaryOverList.isEmpty()) {
			System.out.println("\n해당 임금보다 높은 인원이 존재하지 않습니다.");
		}else {
			for(Employee salary : salaryOverList) {
				System.out.println(salary);
			}
			System.out.println("총 인원 : " + salaryOverList.size() + "명");
		}
		
	}

	// 3번
	public void insertEmployee() {
		System.out.println("[ 새로운 사원 정보 추가 ] ");
		System.out.print("사번 입력 : ");
		int empID = sc.nextInt();
		sc.nextLine();
		System.out.print("사원명 입력 : ");
		String empName = sc.next();
		System.out.print("주민번호 입력 : ");
		String empNo = sc.next();
		System.out.print("이메일 입력 : ");
		String email = sc.next();
		System.out.print("핸드폰 번호 입력 : ");
		String phone = sc.next();
		System.out.print("부서 코드 입력 : ");
		String deptCode = sc.next();
		System.out.print("직책 코드 입력 : ");
		String jobCode = sc.next();
		System.out.print("급여 입력 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.print("보너스 포인트 입력 : ");
		double bonus = sc.nextDouble();
		sc.nextLine();
		
		Employee insertEmployee = new Employee(empID, empName, empNo, email, phone, deptCode, jobCode, salary, bonus);
		
		int result = service.insertEmployee(insertEmployee);
		
		if(result > 0) {
			System.out.println("사원 정보가 추가 되었습니다.");
		}else {
			System.out.println("실패");
		}
		
	}
	
	// 4번
	public void updateEmployee() {
		
		System.out.println("[ 사번으로 사원 정보 수정]");
		int empID = selectID();
		
		System.out.print("변경 이메일 입력 : ");
		String email = sc.next();
		System.out.print("변경 번호 입력 : ");
		String phone = sc.next();
		System.out.print("변경 급여 입력 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		
		Employee update = new Employee();
		
		update.setEmpID(empID);
		update.setEmail(email);
		update.setPhone(phone);
		update.setSalary(salary);
		
		int result = service.updateEmployee(update);
		
		if(result > 0) {
			System.out.println("\n수정 되었습니다.");
		}else {
			System.out.println("\n해당 사번의 사원이 존재하지 않음");
		}
		
	}
	
	// 5번
	public void deleteEmployee() {
		//preparedstatement 사용
		//성공 - 메세지 출력
		int result = 0;
		
		System.out.println("[ 사번으로 사원 정보 삭제 ] ");
		
		int empID = selectID();
		
		result = service.deleteEmployee(empID);
		
		if(result == 1) {
			System.out.println("\n삭제 되었습니다.");
		}else {
			System.out.println("\n해당 사번의 사원이 없습니다.");
		}
		
	}
}
