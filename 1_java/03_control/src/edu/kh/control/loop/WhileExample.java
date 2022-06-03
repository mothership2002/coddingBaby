package edu.kh.control.loop;

import java.util.Scanner;

/*	�ʱ�� �������� �������� �ʰ�
	 *  �ݺ� ���� ������ �����Ӱ� ��������
	 *  �ݺ������� false�� ���� �� ��� ����
	 */
public class WhileExample {
	
	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		int input = 0;
		
		while(input !=9) {
			System.out.println("===============================");
			System.out.println("========== �޴� ���� ==========");
			System.out.println("1. ������");
			System.out.println("2. �̸�");
			System.out.println("3. ���");
			System.out.println("9. ����");
			
			System.out.print("�޴� ���� : ");
			input = sc.nextInt();
			
			switch (input) {
			
			case 1 : System.out.println("�����̸� �ֹ��߽��ϴ�.\n"); break;

			case 2 : System.out.println("�̸��� �ֹ��߽��ϴ�.\n"); break;
			
			case 3 : System.out.println("����� �ֹ��߽��ϴ�.\n"); break;
			
			case 9 : System.out.println("�޴� ������ �����մϴ�.\n"); break;
			
			default : System.out.println("�߸� �Է� �ϼ̽��ϴ�.\n");
			
			}
			
		}
		
	}

	public void ex2() {
		//�Էµ� ��� ���� �� ���ϱ�
		//0�� ���� ��ư
		
		Scanner sc = new Scanner(System.in);
		
		int input = -1; //�ʱⰪ ����
		
		int sum = 0;
		
		while(input != 0 ) {
			System.out.print("���� �Է� : ");
			input = sc.nextInt();
			sum += input;	//������ ��ǲ�� �޾ѱ⶧���� -1�� �ʱⰪ�� �ǹ�x

		}
		
		System.out.println("�հ� : "+ sum);
		
	}

	public void ex3() {
		//�Էµ� ��� ���� �� ���ϱ�
		//0�� ���� ��ư
		
		Scanner sc = new Scanner(System.in);
		
		int input = 0;
		
		int sum = 0;
		
		do {
			System.out.print("���� �Է� : ");
			input = sc.nextInt();
			sum += input;		
		} while (input != 0 ); //do-while
		
		System.out.println("�հ� : "+ sum);
		
	}
	
	
	
}
