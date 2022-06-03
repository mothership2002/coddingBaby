package edu.kh.variable.ex2;

public class PrintExample {

	public static void main(String[] args) {
		
		System.out.println("테스트1");
		System.out.println("테스트2");
		
		System.out.print("테스트3");
		System.out.println();
		System.out.print("테스트4");
		
		System.out.println("-------------------");
		
		int iNum1 = 10;
		int iNum2 = 5;
		int iNum3 = 2;
		
		System.out.println(iNum1 + " + " + iNum2 + " = " + (iNum1 + iNum2));
		
		System.out.printf("%d + %d = %d\n", iNum1, iNum2, iNum1+iNum2);
		
		System.out.println(iNum1 + " + " + iNum1 + " * " + iNum2 + " / "+ iNum3
				+ " = "	+ (iNum1+iNum1*iNum2/iNum3));
		
		System.out.printf("%d + %d * %d / %d = %d\n", 
				iNum1, iNum1, iNum2, iNum3, iNum1+iNum1*iNum2/iNum3);
		
		/* %d 정수형 %o 8진수 %x 16진수
		 * %c 문자 	 %s 문자열
		 * %f 실수 	 %e 지수형태
		 * %g 대입 값 그대로
		 * %A 16진수 실수
		 * %b 논리형
		 */
		
		int iNum4 = 3;
		
		System.out.printf("%d\n", iNum4);
		System.out.printf("%5d\n", iNum4);
		System.out.printf("%-5d\n", iNum4);
		
		System.out.printf("%f\n",10/4.0);
		System.out.printf("%.2f\n", 10/4.0);
		System.out.printf("%.0f\n", 10/4.0);
		
		boolean isTrue = false;
		char ch = '백';
		String str = "배고파요";
		
		System.out.printf("%b / %c / %s\n", isTrue , ch , str);
		
		System.out.println("\\");
		System.out.println("a\tb\tc\td"); 		// tab
		System.out.println("안\n\n\n\n녕"); 	// 개행
		System.out.println("\"안녕\""); 		// \"
		System.out.println("'"); 				// 홑 따옴표
		System.out.println("\u0041"); 			// 유니코드
		
	
	}

}
