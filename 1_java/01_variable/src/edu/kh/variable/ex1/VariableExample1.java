package edu.kh.variable.ex1;

public class VariableExample1 {
	
	public static void main (String[] arge) {
			
		System.out.println(2 * 3.141592653589793 * 10);
		System.out.println(3.141592653589793 * 10 * 10);
		System.out.println(3.141592653589793 * 10 * 10 * 20);
		System.out.println(4 * 3.141592653589793 * 10 * 10);
		
		System.out.println("-----------------------"); // 구분선
		
		double pi = 3.141592653589793 ;
		int r = 10;
		int h = 20;
		
		System.out.println(pi * 2 * r);
		System.out.println(pi * r * r);
		System.out.println(pi * r * r * h);
		System.out.println(pi * 4 * r * r);
		
		// 정리와 대입이 용이 = 유지보수 유리
		// 가독성 증가로 인한 이해 용이
		// 코드의 길이 감소
	}

}
