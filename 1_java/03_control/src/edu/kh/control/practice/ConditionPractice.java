package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {
	
	public void practice1() {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("�ش� ���� �Է� : ");
		int input = sc.nextInt();
		
		String result;
		
		if(input<=0) {
			result = "����� �Է��� �ּ���.";
		} else {
			if(input%2 != 0 )	{
				result = "Ȧ�� �Դϴ�.";
			}else {
				result = "¦�� �Դϴ�.";
			}
		}
		System.out.println(result);
		

	}
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� �Է� : ");
		int kor = sc.nextInt();
		System.out.print("���� ���� �Է� : ");
		int eng = sc.nextInt();
		System.out.print("���� ���� �Է� : ");
		int mat = sc.nextInt();
		
		int sum = kor + eng + mat;
		double avg = sum / 3;
		
		String result;
		
		if(avg>=60) {
			if(kor<40||eng<40||mat<40){
				result = "���հ� �Դϴ�.";
			}else {				
				System.out.println("���� : " + kor);
				System.out.println("���� : " + eng);
				System.out.println("���� : " + mat);
				System.out.println("�հ� : " + sum);
				System.out.printf("��� : %.2f",avg);
				result = "�����մϴ�. �հ��Դϴ�!";
			}
		}else {
			result = "���հ� �Դϴ�.";
		}
		System.out.println(result);
		
		
		
	}
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ش� �� �Է� : ");
		int month = sc.nextInt();
		
		if(month <= 0 || month >12) {
			System.out.println("�ش� ������ ���� �������� �ʽ��ϴ�.");
		}else {
			if(month == 1 || month == 3 || month == 5 
		|| month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.printf("%d���� 31�� ���� �ֽ��ϴ�.\n",month);
			}else {
				System.out.printf("%d���� 30�� ���� �ֽ��ϴ�.\n",month);
			}	
		}
		
	}
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("����(m)�� �Է��� �ּ���. : ");
		double high = sc.nextDouble();
		System.out.print("ü��(kg)�� �Է��� �ּ���. : ");
		double weigh = sc.nextDouble();
		double bmi = weigh/(high*high);
		String ans;
		if(bmi>=30) {
			ans = "�� ��";
		} else {
			if(bmi>=25) {
				ans = "��";
			} else {
				if(bmi>=23) {
					ans = "��ü��";
				} else {
					if(bmi>=18.5) {
						ans = "���� ü��";
					}else {
						ans = "��ü��";
					}
				}
			}
		}
		System.out.println("BMI : "+bmi);
		System.out.println(ans);
		
	}
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�߰� ��� ���� : ");		//20%
		int mt = sc.nextInt();
		System.out.print("�⸻ ��� ���� : ");		//30%
		int lt = sc.nextInt();
		System.out.print("���� ���� : ");  			//30%
		int hw = sc.nextInt();
		System.out.print("�⼮ Ƚ�� : ");			//20 �� 6�������� 20%
		int ck = sc.nextInt();
		
		double point = mt * 0.2 + lt * 0.3 + hw * 0.3 + ck;
		
		//70�� �̻��� ��� Pass, 70�� �̸��̰ų� ��ü ���ǿ� 30% �̻� �Ἦ �� Fail�� ����ϼ���
		String result;
		
		if(ck<=14) {
			result = "Fail [�⼮ Ƚ�� �̴�] [ "+ ck + " / 20 ]";
		} else {
			if(point<70) {
				result = "�߰� ��� ����(20) : " + mt*0.2 + "\n"
						+ "�⸻ ��� ����(30) : " + lt*0.3 + "\n"
						+ "���� ����(30) : " + hw*0.3 + "\n"
						+ "�⼮ Ƚ��(20) : " + (double)ck + "\n"
						+ "���� : " + point + "\n"
						+ "Fail [���� �̴�] ";
			}else {
				result = "�߰� ��� ����(20) : " + mt*0.2 + "\n"
						+ "�⸻ ��� ����(30) : " + lt*0.3 + "\n"
						+ "���� ����(30) : " + hw*0.3 + "\n"
						+ "�⼮ Ƚ��(20) : " + (double)ck + "\n"
						+ "���� : " + point + "\n"
						+ "Pass ";
			}
		}
	
		System.out.println(result);
	}
	
}
