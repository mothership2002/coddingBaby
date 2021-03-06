package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {
	
	public void practice1() {
		
		/*	사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
		 *	단, 입력한 수는 1보다 크거나 같아야 합니다.
		 *	만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
		 *	1이상의 숫자를 입력하세요.
		 * 	1 2 3 4
		 * 	1이상의 숫자를 입력하세요.
		 * 	1이상의 숫자를 입력해주세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input<=0) {
			System.out.println("1이상의 숫자를 입력해주세요.");
		}else {
			for(int i = 1; i <= input; i++) {
				System.out.print(i+" ");
			}
		}
		
		
	}

	public void practice2() {
		//사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
		//단, 입력한 수는 1보다 크거나 같아야 합니다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input<=0) {
			System.out.println("1이상의 숫자를 입력해주세요.");
		}else {
			for(int i = input; i >= 1; i--) {
				System.out.print(i+" ");
			}
		}
		
		
	}

	public void practice3() {
		//1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나를 입력하세요. : ");
		int input = sc.nextInt();
		
		int sum = 0;
		
		for(int i = 1 ; i <= input ; i++) {
			if(i == input) {
				sum += i;
				System.out.printf("%d = %d",i,sum);	
			} else {
				System.out.printf("%d + ",i);
				sum += i;
			}
		}
		
	}
	
	public void practice4() {
		//	사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
		//	만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요
		
		//	첫 번째 숫자 : 8 		첫 번째 숫자 : 4 		첫 번째 숫자 : 9
		//	두 번째 숫자 : 4		두 번째 숫자 : 8 		두 번째 숫자 : 0
		//		4 5 6 7 8				4 5 6 7 8	 		1 이상의 숫자를 입력해주세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int input1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int input2 = sc.nextInt();
		
		if(input1 <= 0 || input2 <=0) {
			System.out.println("1 이상의 숫자를 입력해 주세요.");
		} else { 
			if(input1<=input2) {
				for(int i = input1 ; i <= input2 ; i++) {
					System.out.printf("%d ",i);
				}
			}else {
				for(int i = input2 ; i <= input1 ; i++) {
					System.out.printf("%d ",i);
				}
			}

		}
		
		
	}
	
	public void practice5() {
		/*	사용자로부터 입력 받은 숫자의 단을 출력하세요.
			ex.
			숫자 : 4
			===== 4단 =====
			4 * 1 = 4
			4 * 2 = 8
			4 * 3 = 12
			4 * 4 = 16
			4 * 5 = 20
			4 * 6 = 24
			4 * 7 = 28
			4 * 8 = 32
			4 * 9 = 36
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		System.out.printf("==== %d단 ====\n",input);
		
		for(int i = 1 ; i <= 9 ; i++) {
			System.out.printf("%d * %d = %d\n",input,i,input*i);
		}
		
	}
	
	public void practice6() {
		//사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
		//단, 2~9를 사이가 아닌 수를 입력하면 “2~9 사이 숫자만 입력해주세요”를 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		
		if(input <= 1 || input >=10) {
			System.out.println("2~9 사이의 숫자만 입력해주세요.");
		} else {
			for(int i = input; i<=9; i++ ) {
				System.out.printf("==== %d단 ====\n",i);
				for(int l = 1; l<=9; l++) {
					System.out.printf("%d * %d = %d\n",i,l,i*l);
				}
			}
		}
		
		
	}
	
	public void practice7() {
		//ex.
		//정수 입력 : 4
		//*
		//**
		//***
		//****
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 1 ; i <= num; i++) {
			System.out.println("");
			for(int j = 1 ; j<=i; j++) {
				System.out.print("*");
			}
		}
		
	}
	
	public void practice8() {
		//ex.
		//정수 입력 : 4
		//****
		//***
		//**
		//*
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 1 ; i <= num; i++) {
			System.out.println("");
			for(int j = num ; j >= i; j--) {
				System.out.print("*");
			}
		}
		
	}
	
	public void practice9() {
//		정수 입력 : 4
//		   * 3
//		  ** 2
//	 	 *** 1
//		**** 0
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i<=num; i++) {
			System.out.print("\n");
			for(int l = num-i; l >= 0; l--) {
				System.out.print(" ");	
			}
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
		}


		
	}
	
	public void practice10() {
//		ex.
//		정수 입력 : 4
//		*
//		**
//		***
//		****
//		***
//		**
//		*
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i = 1; i <= input; i++) {
			System.out.println();
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
		}
		for(int l = 1; l<= input-1; l++) {
			System.out.println();
			for(int I = input-l; I >= 1; I--) {
				System.out.print("*");
			}
		}
		
	}
	
	public void practice11() {
	//	ex.
	//	정수 입력 : 4
	//	   *   3
	//	  ***  2
	//	 ***** 1
	//	*******0
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			System.out.println();
			for(int a = 1; a<=num-i; a++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i*2-1; j++) {
				System.out.print("*");
			}
			for(int b = 1; b<=num-i; b++) {
				System.out.print(" ");
			}
		}

	}
	
	public void practice12() {
		//ex.
		//정수 입력 : 5
		// ***** 5
		// *   * 
		// *   * 
		// *   *
		// ***** 5 
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		int jul = 1;
		
		for(int i = 1; i <= num; i++) {
			System.out.println();
			if(i%num <=1) {
				for(int j = 1; j <= num; j++) {
					System.out.print("*");
				}
			} else {
				for(int a = 1; a<=num; a++) {
					if(a%num <=1) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}

			}
		}
			
		
	}
	
	public void practice13() {
	//	1부터 사용자에게 입력 받은 수까지 중에서
	//	1) 2와 3의 배수를 모두 출력하고
	//	2) 2와 3의 공배수의 개수를 출력하세요.
	//	* ‘공배수’는 둘 이상의 수의 공통인 배수라는 뜻으로 어떤 수를 해당 수들로 나눴을 때
	//	모두 나머지가 0이 나오는 수
	//	ex.
	//	자연수 하나를 입력하세요 : 15
	//	2 3 4 6 8 9 10 12 14 15 
	//	count : 2
		
		Scanner sc = new Scanner(System.in);
		System.out.print("자연수 하나를 입력하세요 : ");
		int num = sc.nextInt();
		int count = 0;
		
		for(int i = 2; i<=num; i++) {
			if(i%2 == 0 || i%3 == 0) {
				System.out.printf("%d ",i);
				if(i%2 == 0 && i%3 ==0) {
					count += 1 ;
				}
			} 
		}
		System.out.println("\n공배수 갯수 : "+ count);
		
	}
	
	
}
