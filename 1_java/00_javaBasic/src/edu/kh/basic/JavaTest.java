package edu.kh.basic;

public class JavaTest {
	// class : 자바 코드 생성 영역
	
	public static void  main (String[] args) {
		// 메인 메소드 : 자바 애플리케이션을 실행하기 위한 필요한 메소드
		
		System.out.println("Hello World");
		System.out.println("아침밥은 드셨나요?");
		System.out.println("12345");
		// java 코드 작성 -> 실행 ( 컴파일러가 2진수로 변환 -> java virtual machine 실행) 
		
		System.out.println("--------------------------------");
		
		System.out.println("1 + 2");
		System.out.println(1 + 2);
		
		System.out.println(50 - 23);
		System.out.println(12 * 13);
		System.out.println(327 / 3);
		
		System.out.println("14 * 19 = " + 266);
		System.out.println("14 * 19 = " + 14 * 19);
		
		System.out.println("90 + 70 + 75 = " + 90 + 70 + 75);
		System.out.println("90 + 70 + 75 = " + (90 + 70 + 75));
		
		int A = (int)(Math.random() * 3 + 1);
		System.out.println(A);
		
	}
}
