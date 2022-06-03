package edu.kh.op.ex;

import java.util.Scanner;

public class OpExample {

	public void ex1() {
		//ex1 mothod 
		//OpExample이 가지고 있는 기능 중 ex1()이라는 기능
		System.out.println("1"); // syso컨트롤스페이스
		System.out.println("ㅇ");
	}
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1 입력 : ");
		int input1 = sc.nextInt();
		System.out.print("정수 2 입력 : ");
		int input2 = sc.nextInt();
		
		System.out.printf("%d / %d = %d\n", input1, input2, input1 / input2);
		
		System.out.printf("%d %% %d = %d\n", input1, input2, input1 % input2);
		
	}
	public void ex3() {
		int iNum1 = 10;
		int iNum2 = 10;
		
		iNum1++;
		iNum2--;
		
		System.out.println(iNum1);
		System.out.println(iNum2);
		System.out.println("-------------------------------------------");
		
		//전위 - 연산자가 앞에 있는 상황
		//다른 연산자보다 먼저 증감
		int temp1 = 5;
		System.out.println(++temp1 + 5);
		System.out.println("temp1 : " + temp1);
		
		//후위 - 연산자가 뒤에 있는 상황
		//다른 연산자보다 후에 증감
		int temp2 = 3;
		System.out.println(temp2-- + 2);
		System.out.println("temp2 : " + temp2);
		
		int a = 3;
		int b = 5;
		int c = a++ + --b; //a=4 b=4 c=8
		
		System.out.println("a:"+ a );
		System.out.println("b:"+ b );
		System.out.println("c:"+ c );
		
		
		
	}
	public void ex4() {
		int a = 10;
		int b = 20;
		
		System.out.println(a 		< 	b);
		System.out.println(a 		> 	b);
		System.out.println(a 		!= 	b);
		System.out.println((a == b) == false);
		
		System.out.println("===========================");
		
		int c = 4;
		int d = 5;
		
		System.out.println(c 	 < 	d);
		System.out.println(c + 1 <=	d);
		System.out.println(c	 >= d - 1);
		
		System.out.println((++c != d) == (--c != d));
		
		System.out.println("============================");
		
		int temp = 123;
		System.out.println("temp(이)가 홀수? " + (temp%2 > 0));
		System.out.println("temp(이)가 짝수? " + (temp%2 == 0));
		System.out.println("temp(이)가 3의 배수? " + (temp%3 == 0));
		System.out.println("temp(이)가 4의 배수? " + (temp%4 == 0));
		System.out.println("temp(이)가 5의 배수? " + (temp%5 == 0));

		
		
	}
	public void ex5() {
		
		//&&and ||or
		
		int a = 100;
		System.out.println("a는 100 이상 인가 " + (a>=100));
		System.out.println("a는 짝수인가 " + (a%2==0));
		System.out.println("a는 100 이상 이면서 짝수인가 " + (a>=100 && a%2==0));
		System.out.println("=====================================================");
		
		int b = 1;
		// b는 1부터 10까지의 범위에 포함되어 있는가?
		System.out.println("b는 1이상 인가? " + (b>=1));
		System.out.println("b는 10이하 인가? " + (b<=10));
		System.out.println("b는 1이상이고 10이하 인가? " + (b>=1&b<=10));
		System.out.println("===================================================");
		
		int c = 10;
		System.out.println("c는 10초과 인가? " + (c>10));
		System.out.println("c는 짝수 인가? " + (c%2==0));
		System.out.println("c는 10초과 이거나 짝수 인가? " + (c>10 | c%2==0));
		System.out.println("====================================================");
		//bit 연산 기호 1개 논리연산은 두개 적용
		
		
	}
	public void ex6() {
		boolean bool1 = true;
		boolean bool2 = !bool1;
		
		System.out.println("bool1 = " + bool1);
		System.out.println("bool2 = " + bool2);
		
		System.out.println("=====================================");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("다음 공란에 정수 입력 : ");
		int input1 = sc.nextInt();
		
		boolean bl1 = input1 >=1 && input1 <= 100;
		System.out.println("그 정수는 1과 100 사이의 값 인가 ? : " + bl1);
		
		System.out.println("========================================");
		
		System.out.printf("%d(는)은 1이상 100이하의 정수인가 ? : %b\n", input1 , bl1);
		
		boolean bl2 = input1 < 1 || input1 >100;
		boolean bl3 = !(input1 >=1 && input1 <= 100);
		
		System.out.printf("%d와 1미만 100초과의 수 ? %b / %b\n",input1,bl2,bl3 );
	
		
		
	}
	public void ex7() {
	
		int a = 10;
		a++;	//11
		System.out.println("a : " + a);
		a+=4;	//15
		System.out.println("a : " + a);
		a-=10;	//5
		System.out.println("a : " + a);
		a*=3;	//15
		System.out.println("a : " + a);
		a/=6;	//2
		System.out.println("a : " + a);
		a%=2;	//0
		System.out.println("a : " + a);
		
	}
	public void ex8() {
		
	/*	Scanner sc = new Scanner(System.in);
		System.out.print("다음 정수1 입력 : ");
		int A1 = sc.nextInt();
		int A2 = 10;
		int result1 = A1 > A2 ? A1-- : A2++ ;
		System.out.println("A1 = " + A1);
		System.out.println("A2 = " + A2);
		System.out.println("result1 = " + result1);
	
		System.out.print("다음 정수2 입력 : ");
		int B1 = sc.nextInt();
		int B2 = 30;
		int result2 = B1 > B2 ? B1-- : B2++ ;
		System.out.println("B1 = " + B1);
		System.out.println("B2 = " + B2);
		System.out.println("result2 = " + result2);
		
		System.out.println("========================================");
		
		int num = 30;
		
		String str1 = "num은 30보다 큰 수이다. ";
		String str2 = "num은 30이하인 수 이다.";
		
		String result = num > 30 ? str1 : str2;
		
		System.out.println("==========================================");
		*/
		
		//입력받은 정수 - 음양수 판별
		//단, 0은 양수
		Scanner sc1 = new Scanner(System.in);
		System.out.print("다음 공란에 정수 입력 : ");
		System.out.println("그 정수는 " +
							(sc1.nextInt() >= 0 ? "양수" : "음수") + "입니다.");

	}

}
