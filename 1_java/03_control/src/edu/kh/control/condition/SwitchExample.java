package edu.kh.control.condition;

import java.util.Scanner;

public class SwitchExample {
	/* �� �ϳ��� ����� ���� ����� ���� ó�� 
	 * ���� ����� ���� ���� ���� case ������ ���� ��
	 * switch (){
	 * case �����1 : ~ ; break;
	 * case �����2 : ~ ; break;
	 * case �����3 : ~ ; break;
	 * ...
	 * default : ~ ;
	 */
	public void ex1() {
	/*	 Ű����� ������ �Է� �޾�
		 1 - ���� 2 - ��Ȳ 3 - ��� 4 - �ʷ� �ܴ̿� ��
		
	  	Scanner sc = new Scanner(System.in);
		 System.out.print("���� �Է� : ");
		 int num = sc.nextInt();
		
		 String color;
		
		 if(num<1 || num>4) {
			color = "���";
		 } else {
			if(num == 1) {
				color = "������";
			} else { 
				if(num == 2) {
				color = "��Ȳ��";	
				} else {
					if(num == 3) {
						color = "�����";
					} else {
						color = "�ʷϻ�";
					}
				}
			}
		 }
		
		 System.out.println(color + " �Դϴ�.");
		*/
		
		Scanner sc = new Scanner(System.in);
		
			System.out.print("���� �Է� : ");
			int num = sc.nextInt();
			String color;
		
			switch (num) {
			case 1 :
				color = "������"; break;
			case 2 :
				color = "��Ȳ��"; break;
			case 3 :
				color = "�����"; break;
			case 4 :
				color = "�ʷϻ�"; break;
			default:
				color = "���" ;
		}
		
			System.out.println(color + "�Դϴ�.");
		
	}
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		String team;
		
		switch(input%4) {
		case 1 : team = "����"; break;
		case 2 : team = "ȫ��"; break;
		case 3 : team = "û��"; break;
		default : team = "����";
		}
		
		System.out.println(team + " �Դϴ�.");
		
	}
	public void ex3() {
		//switch �� break ����
		//�� �Է� �� ���� �Ǻ���
		Scanner sc = new Scanner(System.in);
		System.out.print("�ش� �� �Է� : ");
		int month = sc.nextInt();
		
		String season;
		
		switch(month){
		
		case 3 : 
		case 4 : 
		case 5 : season = "��"; break;
		
		case 6 : 
		case 7 : 
		case 8 : season = "����"; break;
		
		case 9 : 
		case 10 : 
		case 11 : season = "����"; break;
		
		case 12 : 
		case 1 : 
		case 2 : season = "�ܿ�"; break;
		
		default : season = "���Է�";
		
		}
		
		System.out.println(season + " �Դϴ�.");
		
	}
	public void ex4() {

		//switch �� ������ �ƴѰ��
		
		//���� 2���� ������ 5�� �� 1���� �Է� �޾� ��� ����
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� 1 �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("������ �Է� : ");
		String input = sc.next();
		System.out.print("���� 2 �Է� : ");
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
				System.out.println("0 ���δ� ���� �� �����ϴ�.");
			} else {
				System.out.printf("%d / %d = %d\n",num1,num2,num1/num2);
			}
			break;
			
		case "%" : 
			System.out.printf("%d %% %d = %d\n",num1,num2,num1%num2); 
			break;
			
		default : 
			System.out.println("���� ���� �ʴ� ������ �Դϴ�.");

		}

		
		
		
		
	}



}
