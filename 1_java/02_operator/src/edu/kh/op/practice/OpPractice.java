package edu.kh.op.practice;

import java.util.Scanner;

public class OpPractice {

	public void practice1(){
	
		Scanner sc = new Scanner(System.in);
		System.out.print("����� �� �� �ֳ��� ? : ");
		int human = sc.nextInt();
		System.out.print("������ �� �� �ֳ��� ? : ");
		int candy = sc.nextInt();
		
		System.out.println("1�δ� ���� �޴� ���� �� : " + candy/human);
		System.out.println("���� ���� �� : " + candy%human);
		
	}
	public void practice2(){

		 Scanner sc = new Scanner(System.in);
		 System.out.print("�̸� : ");
		 String name = sc.next();
		 
		 System.out.print("�г� : ");
		 int age = sc.nextInt();
		 
		 System.out.print("�� : ");
		 int cl = sc.nextInt();
		 
		 System.out.print("��ȣ : ");
		 int num = sc.nextInt();
		 
		 System.out.print("���� : ");
		 String str1 =sc.next();
		 
		 System.out.print("��� ����: ");
		 double point = sc.nextDouble();
		 
		 System.out.printf
		 ("%d�г� %d�� %d�� %s %s�� ������ %.2f�� �Դϴ�.",age,cl,num,name,str1,point);
		 
	 }
	public void practice3(){
		//���� �ϳ��� �Է¹޾� ¦Ȧ�� ���� 0�� ¦��
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		System.out.println(sc.nextInt()/2 == 0 ? "¦���Դϴ�.":"Ȧ���Դϴ�.");
		
			
	}
	public void practice4(){
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� �Է� : ");
		int kor = sc.nextInt();
		System.out.print("���� ���� �Է� : ");
		int math = sc.nextInt();
		System.out.print("���� ���� �Է� : ");
		int eng = sc.nextInt();
		
		double avg = (kor+math+eng)/3.0;
		String pass = kor>=40 && math>=40 && eng>=40 && avg>=60 ? "�հ�" : "���հ�";
		System.out.println("��� ���� : " + avg);
		System.out.println(pass);
	}

}
