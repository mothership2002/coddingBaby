package edu.kh.variable.ex1;

public class VariableExample3 {

	public static void main(String[] args) {
		/*
		 * 형변환 
		 * 값의 형태를 변환하는 것
		 * - 단 boolean 제외
		 * 기본적으로 같은 자료형으로만 연산 가능
		 * 다른 자료형과 연산 시 오류 발생
		 */
		//Auto Casting
		//- 값의 범위가 큰 자료형과 값의 범위가 작은 자료형의 연산시,
		//- 작은 자료형이 큰 자료형으로 자동 변환
		
		int num1 = 10 ;
		double num2 = 3.5 ;
		
		System.out.println("자동 형 변환 결과 : " + (num1 + num2));
		//자동 형 변환으로 오류 자동 수정
		
		int i1 = 3;
		double d1 = i1;
		
		System.out.println("i1 = " + i1 );
		System.out.println("d1 = " + d1 );
		
		System.out.println("d1 + num2 = " + (d1 + num2));
		
		// int -> long 형 변환
		int i2 = 2_100_000_000;
		long l2 = 10_000_000_000l;
		
		long result2 = i2 + l2; 
		
		System.out.println("결과값 : " + result2);
		
		//char -> int 형 변환
		
		char ch3 = 'o';
		int int3 = ch3;
		
		System.out.println("int3 = " + int3); 
		
		char ch4 = '가';
		int int4 = ch4 ;
		
		System.out.println("int4 = " + int4);
		
		//long -> float
		long l5 = 123456789123456789l;
		float f5 = l5 * 100;
		
		//float = int * long
		//float = long * long
		//float = long 결과
		//float = float(자동 형 변환)
		
		System.out.println("f5 = " + f5);
		
		/* 오버플로우
		 * 컴퓨터는 파악 불가능 , 개발자의 수기 계산 필
		 */
			
		int i6 = 2147483647;
		int result6 = i6 + 1;
		System.out.println("result6 = " + result6);
		
		
		
		
	}

}
