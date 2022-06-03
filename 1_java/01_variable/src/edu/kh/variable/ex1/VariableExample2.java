package edu.kh.variable.ex1;

public class VariableExample2 {

	public static void main(String[] args) {
		
		/* JAVA 기본 자료형 8가지
		 * 
		 * boolean : 논리형 1byte
		 * 
		 * byte		1 : 정수형
		 * short	2
		 * int		4
		 * long		8
		 * 
		 * float	4 : 실수형 
		 * double	8
		 * 
		 * char		2
		 * 
		 * String	참조형
		 */
		
		// 변수 선언 : 메모리에 값을 저장할 공간 할당
		
		boolean BooleanData = true ;
		// 메모리에 논리값을 저장할 공간 1byte 할당
		// 할당된 메모리를 BooleanDate로 선언
		System.out.println("BooleanData : " + BooleanData);
		
		byte bNum = 127 ;
		System.out.println("bNum = " + bNum);
		
		short sNum = 32767 ;
		System.out.println("sNum = " + sNum);
		
		int iNum = 2147483647 ;
		System.out.println("iNum = " + iNum);
		// 리터럴 : 변수에 대입되거나 작성 되어지는 값 그 자체
		// + 리터럴 표기법은 자료형선언에 따라 다름
		
		long lNum = 10000000000l ;
		System.out.println("lNum = " + lNum);
		
		float fNum = 1.02f ;
		System.out.println("fNum = " + fNum);
		
		double dNum = 3.32323 ;
		System.out.println("dNum = " + dNum);
		
		char ch = '문';
		System.out.println("char = " + ch);
		
		char ch1 = 66;
		System.out.println("char1 = " + ch1);
		
		//변수 명명 규칙
		//1. 대소문자 구별 , 길이제한 X
		//2. 예약어 사용 X
		//3. 숫자로 시작 불가능 
		//4. 특수문자 $ _ 사용 가능 관례적 사용 X
		//5. 카멜표기법 차용
		
		System.out.println("------------------");
		
		int A = 10;
		A = 20;
		//초기화
		
		/* 상수 :
		 * - 변수의 한종류
		 * - 한번 입력 시 변경 불가능
		 * - 자료형 앞 final 키워드 작성
		 * - 상수는 모두 대문자로 작성, 다 단어 작성 시 '_' 사용
		 * 
		 * 변하지 않는 값에 적용
		 * 특정한 값에 의미부여
		 * 
		 */
		
		final double PI_VALUE = 3.141592;
		
		System.out.println( 1 + 1.1 );
		
		int x = 1;
		double y = 1.3;
		System.out.println( x + y );
		
	}

}
