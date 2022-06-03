package edu.kh.exception.model.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionService {
	
	private Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		
		System.out.println("두 정수를 입력 받아 나누기한 몫을 출력 ");
		
		System.out.print("정수 1 입력 : ");
		int input1 = sc.nextInt();
		System.out.print("정수 2 입력 : ");
		int input2 = sc.nextInt();
		
		try {
			System.out.println("결과 : "+ input1/input2);
		} catch(ArithmeticException e ) {
			System.out.println("infinity");
		}
		
		
		//일부 예외 == UnCheckedException (try-catch사용)

	}
	
	public int inputNumber() {

		int num = 0;
	
		while(true) {
			try{
				System.out.print("정수 입력 : ");
				num = sc.nextInt();
				sc.nextLine();
				break;
			}catch(InputMismatchException e) {
				System.out.println("잘못 입력, 정수만 입력");
				sc.nextLine();
			}
		}
		return num;
		
	}
	public void ex2() {
		int sum = 0; 
		
		for(int i=0; i<3;i++) {
			sum += inputNumber();
		}
		System.out.println("합계 : "+ sum);
	}

	public void ex3() {
		try {
			System.out.print("입력1 : ");
			int num1 = sc.nextInt();
				//InputMismatchException
			System.out.print("입력2 : ");
			int num2 = sc.nextInt();
	
			System.out.println("결과 : " + (num1/num2));
				//ArithemticException
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없");
		}catch(InputMismatchException e) {
			System.out.println("정수만 입력 해줘");
		}
		
	}
	
	public void ex4() {
		//try - catch - finally
		try {
			System.out.println(4/0);
			
		}catch(ArithmeticException e ) {
			System.out.println("예외 처리");
			System.out.println(e.getClass());
			//어떤 예외 클래스
			System.out.println(e.getMessage());
			//예외 발생 시 출력 매시지
			System.out.println(e);
			
			e.printStackTrace();
			//예외가 발생하기까지의 메소드 내역 출력
		}finally {
			System.out.println("무조건 수행");
		}
		
		
		// catch 매개변수 사용
		
		
		
	}
	
//	====================================================
	
	public void ex5() {
		//throws 상위 메소드에 예외값을 떠넘김
		//throw  예외를 강제 발생 (현재 메소드에 예외값 전달)
		try {
			methodA();
		}catch(Exception e) {
			System.out.println("예외");
			e.printStackTrace();
		}
	}
	
	public void methodA() throws IOException {
		
		methodB();
	}
	
	public void methodB() throws IOException {
		
		methodC();
	
	}
	
	public void methodD() {
		
		throw new RuntimeException();
		//CheckedException
		//-RuntimeException류를 제외 
		//시스템적 충돌 또는 오류
		//if문과 같은 단순코드로는 해결 불가

		
		//UnCheckedException
		//-RuntimeException 산술적 입력 오류, 인덱스범위초과,etc
		//개발자의 코딩 실수 , 사용자의 입력 값 오류
		//if문으로도 해결가능
		//try catch throw쓸필요X
		
	}
	
	public void methodC() throws IOException {
		
		//throws ioexception == IOException 가능성 유
		//UnCheckedException 선택적으로 예외처리 가능
		
		throw new IOException();
		
	}
	
}
