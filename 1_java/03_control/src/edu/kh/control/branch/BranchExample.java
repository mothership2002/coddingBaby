package edu.kh.control.branch;

import java.util.Scanner;

public class BranchExample {
	
	public void ex1() {
		// 1 ~ 10 1++ 
		// if 5 print , end
		
		for(int i = 1 ; i <=10 ; i++) {
			System.out.print(i+" ");
			if(i==5) {
				System.out.println("����� �����մϴ�"); break;
			}
		}
	}
	
	public void ex2() {
		
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		int sum = 0;
		
		while(true) {
			System.out.print("���� �Է� : ");
			i = sc.nextInt();
			if(i==0) {
				break;
			}
			sum += i;
			
		}
		System.out.println("�հ� : "+sum);
		
	}
	
	public void ex3() {
		
		//exit - end - print
		Scanner sc = new Scanner(System.in);
		String str = "";
		
		while (true) {
			System.out.print("���ڿ� �Է� \n(exit@ �Է� �� ����) : ");
			String input = sc.nextLine();
			if(input.equals("exit@")) {
				break;
			}
			str += input+"\n";
		}
		System.out.println(str);			//str.equals("str") <- == ���ڿ�(������)
	}
	
	public void ex4() {
		//��ø �ݺ��� in break
		//2-2 3-3...9-9
		
		/*loop1*/for(int i=2;i<=9;i++) {
			
			for(int j=1;j<=9;j++) {
				System.out.printf(" %d X %d = %2d ",i,j,i*j);
				if(j==i) {
					break /*loop1*/;
				}
			}
		System.out.println();
		}
		
	}
	
	public void ex5() {
		//continue - ���� �ݺ����� �Ѿ
		//break
		//1~10 1++ %3 = 0 X
		for(int i=1;i<=10;i++) {
			if(i%3==0) {
				continue;
			}
			System.out.print(i+" ");
		}
		
	}
	
	public void ex6() {
		//1~100 1++
		//%5 , 40-end
		for(int i=1;i<=100;i++) {	//�켱���� �Ǻ� - ���������� ������������ 
			if(i%5==0) {
				continue;
			}else {
				if(i>=40) {
					break;
				}
			}
			System.out.print(i+" ");
			
		}
		
	}
	
	public void rps() {
		//����������
		//�Ǽ�
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϴ� ���� Ƚ�� : ");
		int game = sc.nextInt();
		
		int w = 0;
		int l = 0;
		int d = 0;
		
		for(int i=1; i<=game; i++) {
			System.out.printf("\n%d��° ����\n",i);
			System.out.println("����/����/�� �� �ϳ��� �Է��ϼ���. :");
			String str = sc.next();
			//���� ����
			//1-s 2-r 3-p
			//switch
			//	Math.random() * 3 + 1;//0.0~1.0���� ����
			int A = (int)(Math.random() * 3 + 1);
			
			String com;
			
			switch (A){
			case 1 : com = "����"; break;
			case 2 : com = "����"; break;
			default : com = "��";		
			}
			
			System.out.printf("��ǻ�ʹ� [%s] �Դϴ�.",com);
			String result = "";
			
			if(str.equals(com)) {
				System.out.print("\n�����ϴ�.");
				d += 1 ;
			} else {
				if(str.equals("����")&&com.equals("����")) {
						result = "\n�����ϴ�.";
						l += 1;
				} else if (str.equals("��")&&str.equals("����")) {
						result = "\n�����ϴ�.";
						l += 1;
				} else if (str.equals("����")&&str.equals("��")) {
						result = "\n�����ϴ�.";	
						l += 1;
				} else {
						result = "\n�̰���ϴ�.";
						w += 1;
				}
			}
			System.out.println(result);
		}
		double rate = w;
		System.out.printf("\n�·��� %.2f%% �Դϴ�.\n",rate/game*100);
		System.out.printf("�� ������ %d�� %d�� %d�� �Դϴ�.\n",w,d,l);
	}

}
