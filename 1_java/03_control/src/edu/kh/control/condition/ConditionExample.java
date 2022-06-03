package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionExample {
	
	public void ex1() {
		//������ if�� ������ �糦
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		if(input >= 0) {
			if(input ==0) {
				System.out.println("0 �Դϴ�.");
			} else {
				System.out.println("����Դϴ�.");
			}
		} else {
			System.out.println("�����Դϴ�.");
		}
	}
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		//Ȧ¦ �˻�
	/*	if(input%2 != 0) {
			System.out.println("Ȧ�� �Դϴ�.");
		} else {
			System.out.println("¦�� �Դϴ�.");
		}
		*/
		if(input%2 == 0 ) {
			if(input == 0) {
				System.out.println("0 �Դϴ�.");
			} else {
				System.out.println("¦���Դϴ�.");
			}
		} else {
			System.out.println("Ȧ���Դϴ�.");
		}
	}
	public void ex3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		if(input>0){
			System.out.println("����Դϴ�.");
		}else if(input == 0){
			System.out.println("0 �Դϴ�.");
		}else {
			System.out.println("�����Դϴ�.");
		}
	}
	public void ex4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ش� �� �Է� : ");
		int month = sc.nextInt();
		
		String season; 
				
		if(month >2 && month<=5) {
			season = "��";
		} else if(month>5 && month<=8) {
			season = "����";
		} else if(month>8 && month<=11) {
			season = "����";
		} else if(month == 1 || month == 2 || month == 12){
			season = "�ܿ�";
		} else {
			season = "�ش� ���� �������� �ʽ��ϴ�.";
		}
		
		System.out.println(season);
		
	}
	public void ex5() {
		//���̸� �Է¹޾� 13�� ���� - ��� �Դϴ�.
		//13�� �ʰ� 19���� - û�ҳ� �Դϴ�.
		//19�ʰ� - ���� �Դϴ�.
		Scanner sc = new Scanner(System.in);
		System.out.print("�ι��� ���� �Է� : ");
		int age = sc.nextInt();
		
		String condition;
		
		if(age <= 13 && age > 0) {
			condition = "��� �Դϴ�.";
		}else if(age <= 19) {
			condition = "û�ҳ� �Դϴ�.";
		}else if(age > 19) {
			condition = "���� �Դϴ�.";
		}else {
			condition = "�ش� ���̴� �������� �ʽ��ϴ�.";
		}
		
		System.out.println(condition);
		
	}
	public void ex6() {
		//���� ���� ����
		//������ �Է� ���� �� 90�� �̻� A 
		//80�̻� B
		//70�̻� C
		//60�̻� D
		//60�̸� f
		//0 �̸� 100�ʰ� �߸�
		Scanner sc = new Scanner(System.in);
		System.out.print("�ش� ���� �Է� : ");
		int point = sc.nextInt();
		
		if(point<0 || point >100) {
			System.out.println("�ش� ������ �߸� �Է��ϼ̽��ϴ�.");
		}else if(point>=90) {
			System.out.println("A");
		}else if(point>=80) {
			System.out.println("B");
		}else if(point>=70) {
			System.out.println("C");
		}else if(point>=60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		
	}
	public void ex7() {

		// ���̱ⱸ ž�� ���� �˻�
				// ���̰� 12�� �̻�, Ű 140.0cm �̻� �� ��쿡�� "ž�� ����"
				// ���̰� 12�̸��� ��� : "���� ������ �ƴմϴ�."
				// Ű�� 140.0cm �̸� : "���� Ű�� �ƴմϴ�."
				// ���̸� 0�� �̸�, 100�� �ʰ� �� : "�߸� �Է��ϼ̽��ϴ�."
		Scanner sc = new Scanner(System.in);
		System.out.print("�ش� �ι��� ���� �Է� : ");
		int age = sc.nextInt();
		System.out.print("�ش� �ι��� ���� �Է� : ");
		double high = sc.nextDouble();
		
		if(age<0 || age>100) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}else if(high<140.0) {
			System.out.println("���� Ű�� �ƴմϴ�.");
		}else if(age<12) {
			System.out.println("���� ������ �ƴմϴ�.");
		}else {
			System.out.println("ž�� �����մϴ�.");
		}
	
	
	
	}
	public void ex8( ) {
		// ���̱ⱸ ž�� ���� �˻� ���α׷� 
		   // ���� - ���� : 12�� �̻�
		   //     -  Ű : 140.0cm �̻�
		   
		   // ���̸� 0~100�� ���̷� �Է����� ���� ��� : "���̸� �߸� �Է� �ϼ̽��ϴ�." if1
		   // Ű�� 0~250.0cm ���̷� �Է����� ���� ��� : "Ű�� �߸� �Է� �ϼ̽��ϴ�."	el1
		   // -> �Է��� ���� ���� �˻縦 �����Ͽ� �߸��� ��� ���α׷� ����
		   
		   // ���� O , Ű X : "���̴� �����ϳ�, Ű�� ����ġ ����"; else2-2	
		   // ���� X , Ű O : "Ű�� �����ϳ�, ���̴� ����ġ ����"; if2-2
		   // ���� X , Ű X : "���̿� Ű ��� ����ġ ����"; if2-1
		   // ���� O , Ű O : "ž�� ����"	else2
		Scanner sc = new Scanner(System.in);
		System.out.print("�ش� �ι��� ���� �Է� : ");
		int age = sc.nextInt();
		
		String result ;
		
		if(age>=0 && age<100) {
			System.out.print("�ش� �ι��� ���� �Է� : ");
			double high = sc.nextDouble();
			if(high>250.0 || high < 0) {
				result = "������ �߸� �Է� �ϼ̽��ϴ�.";
			} else {
				if(age < 12 && high < 140.0) {
					result = "���̿� ���� ��� ����ġ ����.";
				} else {
					if(age >= 12 && high < 140.0) {
						result = "���̴� �����ϳ� ���尡 ����ġ ����.";
					}else if(age <12 && high >= 140.0){
						result = "����� �����ϳ� ���̴� ����ġ ����.";
					}else {
						result = "ž�� ����";
					}
				}
			}
		} else {
			result = "���̸� �߸� �Է� �ϼ̽��ϴ�.";
		}
		System.out.println(result);
	
		/* ����԰�
	 *       Scanner sc = new Scanner(System.in);
      
      System.out.print("���� �Է� : ");
      int age = sc.nextInt();
      
      String result;
      
      if(age < 0 || age > 100) {
         result = "���̸� �߸� �Է� �ϼ̽��ϴ�.";
      
      } else {
         System.out.print("Ű �Է� : ");
         double height = sc.nextDouble();
         
         if(height < 0  || height > 250) {
            result = "Ű�� �߸� �Է� �ϼ̽��ϴ�.";
            
         } else {
            
            if(age < 12 && height >= 140.0) { // ���� X , Ű O
               result = "Ű�� �����ϳ�, ���̰� ����ġ ����";

            } else if(age >= 12 && height < 140.0) { // ���� O , Ű X
               result = "���̴� �����ϳ�, Ű�� ����ġ ����";
               
            } else if(age < 12 && height < 140.0) {
               result = "���̿� Ű ��� ����ġ ����";
            
            } else {
               result = "ž�� ����";
            }
         }           //�ٽ��� ���� ������ �� ����.
      }
      
      System.out.println(result);
      
      
      

	 */

	
	}
	
	
	
	
}
	
