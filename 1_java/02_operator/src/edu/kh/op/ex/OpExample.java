package edu.kh.op.ex;

import java.util.Scanner;

public class OpExample {

	public void ex1() {
		//ex1 mothod 
		//OpExample�� ������ �ִ� ��� �� ex1()�̶�� ���
		System.out.println("1"); // syso��Ʈ�ѽ����̽�
		System.out.println("��");
	}
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� 1 �Է� : ");
		int input1 = sc.nextInt();
		System.out.print("���� 2 �Է� : ");
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
		
		//���� - �����ڰ� �տ� �ִ� ��Ȳ
		//�ٸ� �����ں��� ���� ����
		int temp1 = 5;
		System.out.println(++temp1 + 5);
		System.out.println("temp1 : " + temp1);
		
		//���� - �����ڰ� �ڿ� �ִ� ��Ȳ
		//�ٸ� �����ں��� �Ŀ� ����
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
		System.out.println("temp(��)�� Ȧ��? " + (temp%2 > 0));
		System.out.println("temp(��)�� ¦��? " + (temp%2 == 0));
		System.out.println("temp(��)�� 3�� ���? " + (temp%3 == 0));
		System.out.println("temp(��)�� 4�� ���? " + (temp%4 == 0));
		System.out.println("temp(��)�� 5�� ���? " + (temp%5 == 0));

		
		
	}
	public void ex5() {
		
		//&&and ||or
		
		int a = 100;
		System.out.println("a�� 100 �̻� �ΰ� " + (a>=100));
		System.out.println("a�� ¦���ΰ� " + (a%2==0));
		System.out.println("a�� 100 �̻� �̸鼭 ¦���ΰ� " + (a>=100 && a%2==0));
		System.out.println("=====================================================");
		
		int b = 1;
		// b�� 1���� 10������ ������ ���ԵǾ� �ִ°�?
		System.out.println("b�� 1�̻� �ΰ�? " + (b>=1));
		System.out.println("b�� 10���� �ΰ�? " + (b<=10));
		System.out.println("b�� 1�̻��̰� 10���� �ΰ�? " + (b>=1&b<=10));
		System.out.println("===================================================");
		
		int c = 10;
		System.out.println("c�� 10�ʰ� �ΰ�? " + (c>10));
		System.out.println("c�� ¦�� �ΰ�? " + (c%2==0));
		System.out.println("c�� 10�ʰ� �̰ų� ¦�� �ΰ�? " + (c>10 | c%2==0));
		System.out.println("====================================================");
		//bit ���� ��ȣ 1�� �������� �ΰ� ����
		
		
	}
	public void ex6() {
		boolean bool1 = true;
		boolean bool2 = !bool1;
		
		System.out.println("bool1 = " + bool1);
		System.out.println("bool2 = " + bool2);
		
		System.out.println("=====================================");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ������ ���� �Է� : ");
		int input1 = sc.nextInt();
		
		boolean bl1 = input1 >=1 && input1 <= 100;
		System.out.println("�� ������ 1�� 100 ������ �� �ΰ� ? : " + bl1);
		
		System.out.println("========================================");
		
		System.out.printf("%d(��)�� 1�̻� 100������ �����ΰ� ? : %b\n", input1 , bl1);
		
		boolean bl2 = input1 < 1 || input1 >100;
		boolean bl3 = !(input1 >=1 && input1 <= 100);
		
		System.out.printf("%d�� 1�̸� 100�ʰ��� �� ? %b / %b\n",input1,bl2,bl3 );
	
		
		
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
		System.out.print("���� ����1 �Է� : ");
		int A1 = sc.nextInt();
		int A2 = 10;
		int result1 = A1 > A2 ? A1-- : A2++ ;
		System.out.println("A1 = " + A1);
		System.out.println("A2 = " + A2);
		System.out.println("result1 = " + result1);
	
		System.out.print("���� ����2 �Է� : ");
		int B1 = sc.nextInt();
		int B2 = 30;
		int result2 = B1 > B2 ? B1-- : B2++ ;
		System.out.println("B1 = " + B1);
		System.out.println("B2 = " + B2);
		System.out.println("result2 = " + result2);
		
		System.out.println("========================================");
		
		int num = 30;
		
		String str1 = "num�� 30���� ū ���̴�. ";
		String str2 = "num�� 30������ �� �̴�.";
		
		String result = num > 30 ? str1 : str2;
		
		System.out.println("==========================================");
		*/
		
		//�Է¹��� ���� - ����� �Ǻ�
		//��, 0�� ���
		Scanner sc1 = new Scanner(System.in);
		System.out.print("���� ������ ���� �Է� : ");
		System.out.println("�� ������ " +
							(sc1.nextInt() >= 0 ? "���" : "����") + "�Դϴ�.");

	}

}
