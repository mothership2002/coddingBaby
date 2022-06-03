package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {
	
	public void practice1() {
		
		/*	����ڷκ��� �� ���� ���� �Է� �޾� 1���� �� ���ڱ����� ���ڵ��� ��� ����ϼ���.
		 *	��, �Է��� ���� 1���� ũ�ų� ���ƾ� �մϴ�.
		 *	���� 1 �̸��� ���ڰ� �Էµƴٸ� ��1 �̻��� ���ڸ� �Է����ּ��䡰�� ����ϼ���.
		 *	1�̻��� ���ڸ� �Է��ϼ���.
		 * 	1 2 3 4
		 * 	1�̻��� ���ڸ� �Է��ϼ���.
		 * 	1�̻��� ���ڸ� �Է����ּ���.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		int input = sc.nextInt();
		
		if(input<=0) {
			System.out.println("1�̻��� ���ڸ� �Է����ּ���.");
		}else {
			for(int i = 1; i <= input; i++) {
				System.out.print(i+" ");
			}
		}
		
		
	}

	public void practice2() {
		//����ڷκ��� �� ���� ���� �Է� �޾� 1���� �� ���ڱ����� ��� ���ڸ� �Ųٷ� ����ϼ���.
		//��, �Է��� ���� 1���� ũ�ų� ���ƾ� �մϴ�.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		int input = sc.nextInt();
		
		if(input<=0) {
			System.out.println("1�̻��� ���ڸ� �Է����ּ���.");
		}else {
			for(int i = input; i >= 1; i--) {
				System.out.print(i+" ");
			}
		}
		
		
	}

	public void practice3() {
		//1���� ����ڿ��� �Է� ���� �������� �������� ���� for���� �̿��Ͽ� ����ϼ���
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �ϳ��� �Է��ϼ���. : ");
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
		//	����ڷκ��� �� ���� ���� �Է� �޾� �� ������ ���ڸ� ��� ����ϼ���.
		//	���� 1 �̸��� ���ڰ� �Էµƴٸ� ��1 �̻��� ���ڸ� �Է����ּ��䡰�� ����ϼ���
		
		//	ù ��° ���� : 8 		ù ��° ���� : 4 		ù ��° ���� : 9
		//	�� ��° ���� : 4		�� ��° ���� : 8 		�� ��° ���� : 0
		//		4 5 6 7 8				4 5 6 7 8	 		1 �̻��� ���ڸ� �Է����ּ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù ��° ���� : ");
		int input1 = sc.nextInt();
		System.out.print("�� ��° ���� : ");
		int input2 = sc.nextInt();
		
		if(input1 <= 0 || input2 <=0) {
			System.out.println("1 �̻��� ���ڸ� �Է��� �ּ���.");
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
		/*	����ڷκ��� �Է� ���� ������ ���� ����ϼ���.
			ex.
			���� : 4
			===== 4�� =====
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
		System.out.print("���� : ");
		int input = sc.nextInt();
		System.out.printf("==== %d�� ====\n",input);
		
		for(int i = 1 ; i <= 9 ; i++) {
			System.out.printf("%d * %d = %d\n",input,i,input*i);
		}
		
	}
	
	public void practice6() {
		//����ڷκ��� �Է� ���� ������ �ܺ��� 9�ܱ��� ����ϼ���.
		//��, 2~9�� ���̰� �ƴ� ���� �Է��ϸ� ��2~9 ���� ���ڸ� �Է����ּ��䡱�� ����ϼ���.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int input = sc.nextInt();
		
		if(input <= 1 || input >=10) {
			System.out.println("2~9 ������ ���ڸ� �Է����ּ���.");
		} else {
			for(int i = input; i<=9; i++ ) {
				System.out.printf("==== %d�� ====\n",i);
				for(int l = 1; l<=9; l++) {
					System.out.printf("%d * %d = %d\n",i,l,i*l);
				}
			}
		}
		
		
	}
	
	public void practice7() {
		//ex.
		//���� �Է� : 4
		//*
		//**
		//***
		//****
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
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
		//���� �Է� : 4
		//****
		//***
		//**
		//*
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		
		for(int i = 1 ; i <= num; i++) {
			System.out.println("");
			for(int j = num ; j >= i; j--) {
				System.out.print("*");
			}
		}
		
	}
	
	public void practice9() {
//		���� �Է� : 4
//		   * 3
//		  ** 2
//	 	 *** 1
//		**** 0
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
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
//		���� �Է� : 4
//		*
//		**
//		***
//		****
//		***
//		**
//		*
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
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
	//	���� �Է� : 4
	//	   *   3
	//	  ***  2
	//	 ***** 1
	//	*******0
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
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
		//���� �Է� : 5
		// ***** 5
		// *   * 
		// *   * 
		// *   *
		// ***** 5 
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
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
	//	1���� ����ڿ��� �Է� ���� ������ �߿���
	//	1) 2�� 3�� ����� ��� ����ϰ�
	//	2) 2�� 3�� ������� ������ ����ϼ���.
	//	* ����������� �� �̻��� ���� ������ ������ ������ � ���� �ش� ����� ������ ��
	//	��� �������� 0�� ������ ��
	//	ex.
	//	�ڿ��� �ϳ��� �Է��ϼ��� : 15
	//	2 3 4 6 8 9 10 12 14 15 
	//	count : 2
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�ڿ��� �ϳ��� �Է��ϼ��� : ");
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
		System.out.println("\n����� ���� : "+ count);
		
	}
	
	
}