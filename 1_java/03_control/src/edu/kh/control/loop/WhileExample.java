package edu.kh.control.loop;

import java.util.Scanner;

/*	초기식 증감식이 존재하지 않고
	 *  반복 종료 조건을 자유롭게 설정가능
	 *  반복조건이 false를 만족 할 경우 종료
	 */
public class WhileExample {
	
	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		int input = 0;
		
		while(input !=9) {
			System.out.println("===============================");
			System.out.println("========== 메뉴 선택 ==========");
			System.out.println("1. 떡볶이");
			System.out.println("2. 쫄면");
			System.out.println("3. 김밥");
			System.out.println("9. 종료");
			
			System.out.print("메뉴 선택 : ");
			input = sc.nextInt();
			
			switch (input) {
			
			case 1 : System.out.println("떡볶이를 주문했습니다.\n"); break;

			case 2 : System.out.println("쫄면을 주문했습니다.\n"); break;
			
			case 3 : System.out.println("김밥을 주문했습니다.\n"); break;
			
			case 9 : System.out.println("메뉴 선택을 종료합니다.\n"); break;
			
			default : System.out.println("잘못 입력 하셨습니다.\n");
			
			}
			
		}
		
	}

	public void ex2() {
		//입력된 모든 정수 합 구하기
		//0은 종료 버튼
		
		Scanner sc = new Scanner(System.in);
		
		int input = -1; //초기값 변경
		
		int sum = 0;
		
		while(input != 0 ) {
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			sum += input;	//어차피 인풋을 받앗기때문에 -1의 초기값은 의미x

		}
		
		System.out.println("합계 : "+ sum);
		
	}

	public void ex3() {
		//입력된 모든 정수 합 구하기
		//0은 종료 버튼
		
		Scanner sc = new Scanner(System.in);
		
		int input = 0;
		
		int sum = 0;
		
		do {
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			sum += input;		
		} while (input != 0 ); //do-while
		
		System.out.println("합계 : "+ sum);
		
	}
	
	
	
}
