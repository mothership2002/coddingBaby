package edu.kh.control.condition;

import java.util.Scanner;

public class SwitchExample {
	/* 식 하나의 결과로 여러 경우의 수를 처리 
	 * 식의 결과로 얻은 값과 같은 case 구문이 수행 됨
	 * switch (){
	 * case 결과값1 : ~ ; break;
	 * case 결과값2 : ~ ; break;
	 * case 결과값3 : ~ ; break;
	 * ...
	 * default : ~ ;
	 */
	public void ex1() {
	/*	 키보드로 정수를 입력 받아
		 1 - 빨강 2 - 주황 3 - 노랑 4 - 초록 이외는 백
		
	  	Scanner sc = new Scanner(System.in);
		 System.out.print("정수 입력 : ");
		 int num = sc.nextInt();
		
		 String color;
		
		 if(num<1 || num>4) {
			color = "흰색";
		 } else {
			if(num == 1) {
				color = "빨강색";
			} else { 
				if(num == 2) {
				color = "주황색";	
				} else {
					if(num == 3) {
						color = "노랑색";
					} else {
						color = "초록색";
					}
				}
			}
		 }
		
		 System.out.println(color + " 입니다.");
		*/
		
		Scanner sc = new Scanner(System.in);
		
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();
			String color;
		
			switch (num) {
			case 1 :
				color = "빨강색"; break;
			case 2 :
				color = "주황색"; break;
			case 3 :
				color = "노랑색"; break;
			case 4 :
				color = "초록색"; break;
			default:
				color = "흰색" ;
		}
		
			System.out.println(color + "입니다.");
		
	}
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		String team;
		
		switch(input%4) {
		case 1 : team = "백팀"; break;
		case 2 : team = "홍팀"; break;
		case 3 : team = "청팀"; break;
		default : team = "흑팀";
		}
		
		System.out.println(team + " 입니다.");
		
	}
	public void ex3() {
		//switch 문 break 역할
		//달 입력 시 계절 판별법
		Scanner sc = new Scanner(System.in);
		System.out.print("해당 월 입력 : ");
		int month = sc.nextInt();
		
		String season;
		
		switch(month){
		
		case 3 : 
		case 4 : 
		case 5 : season = "봄"; break;
		
		case 6 : 
		case 7 : 
		case 8 : season = "여름"; break;
		
		case 9 : 
		case 10 : 
		case 11 : season = "가을"; break;
		
		case 12 : 
		case 1 : 
		case 2 : season = "겨울"; break;
		
		default : season = "오입력";
		
		}
		
		System.out.println(season + " 입니다.");
		
	}
	public void ex4() {

		//switch 식 정수가 아닌경우
		
		//정수 2개와 연산자 5개 중 1개를 입력 받아 결과 도출
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("연산자 입력 : ");
		String input = sc.next();
		System.out.print("정수 2 입력 : ");
		int num2 = sc.nextInt();
			
		switch(input) {
		case "+" :
			System.out.printf("%d + %d = %d\n",num1,num2,num1+num2);
			break;
			
		case "-" : 
			System.out.printf("%d - %d = %d\n",num1,num2,num1-num2);
			break;
			
		case "*" : 
			System.out.printf("%d * %d = %d\n",num1,num2,num1*num2);
			break;
		
		case "/" : 
			if(num2 == 0) {
				System.out.println("0 으로는 나눌 수 없습니다.");
			} else {
				System.out.printf("%d / %d = %d\n",num1,num2,num1/num2);
			}
			break;
			
		case "%" : 
			System.out.printf("%d %% %d = %d\n",num1,num2,num1%num2); 
			break;
			
		default : 
			System.out.println("존재 하지 않는 연산자 입니다.");

		}

		
		
		
		
	}



}
