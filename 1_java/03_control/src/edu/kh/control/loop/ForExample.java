package edu.kh.control.loop;

import java.util.Scanner;

import org.w3c.dom.css.Counter;

public class ForExample {
	/* for ��
	 * ������ Ƚ���� ������ �ݺ���
	 * for(�ʱ��,���ǽ�,������){code}
	 * - �ʱ�� : for���� �����ϴ� �뵵�� ���� ����
	 * - ���ǽ� : for���� �ݺ����θ� �����ϴ� �� (true,false)
	 * 				(����, �ʱ�Ŀ� ����� ������ �̿��Ͽ� ���ǹ� �ۼ�)
	 * - ������ : �ʱ�Ŀ� ���� ������ for���� �ݺ� �� ������ 
	 * 				�������� ���ǽ��� ����� ���ϰ� �ϴ� ��.
	 */
	
	public void ex1() {
		for (int i = 1 ; i <= 10 ;  i += 2) {
			System.out.printf("%d\n",i);
			//�ݺ����� ���ǽ��� true�϶��� �ݺ�
		}
		
	}
	
	public void ex2() {
		for(int i = 3; i<=7 ; i++) {
			System.out.printf("%d\n",i);
		}
	}
	
	public void ex3() {
		for(int i = 2; i<=15 ; i++) {
			System.out.printf("%d\n",i);
		}
	}
	
	public void ex4() {
		//1���� �Է¹��� ������ 1������
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�������� �ۼ� �� ���� �Է� : ");
		int input = sc.nextInt();
		
		for(int i = 1 ; i <= input ; i++) {
			System.out.printf("%d\n",i);
		}
		
	}
	
	public void ex5() {
		//1~input 2++
		Scanner sc = new Scanner(System.in);
		System.out.print("�������� �ۼ� �� ���� �Է� : ");
		int input = sc.nextInt();
		
		for(int i = 1 ; i <= input ; i += 2) {
			System.out.printf("%d\n",i);
		}
		
	}
	
	public void ex6() {
		//1~input 0.5++
		Scanner sc = new Scanner(System.in);
		System.out.print("�������� �ۼ� �� �� �Է� : ");
		double input = sc.nextDouble();
		
		for(double i = 1 ; i <= input ; i += 0.5) {
			System.out.printf("%.1f\n",i);
		}
	}
	
	public void ex7() {
		//���� ���ĺ�r

		for(int i = 'A' ; i <= 'Z'; i++ ) {
			System.out.printf("%s ",(char)i);
		}
		System.out.println("\n======================================================");
		
		for(char i = 'A'; i<='Z';i++) {
			System.out.printf("%s ",i);
		}
	}
	
	public void ex8() {
		// 10 ~ 1
		for(int i = 10 ; i >= 1 ; i--) {
			System.out.printf("%d\n",i);
		}
		
	}
	
	public void ex9() {
		//for�� ��ȭ
		//�ݺ��� ��� ���� ����
		
		//1~10 ��� ������ ��
		int sum = 0 ;
		for(int i = 1 ; i <= 10 ; i ++) {
			sum += i ;
		}
		System.out.println("�հ� : " + sum);
	}
	//ex9 ����� (����)
	
	public void ex10() {
		//���� 5��
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i = 1 ; i <= 5 ; i++) {
			System.out.print("���� �Է� "+ i + " : ");
			int input = sc.nextInt();
			//{}�ȿ��� ������ ������ {}�ۿ����� �����
			sum += input;
			
		}
		
		System.out.println("�հ� : " + sum);
		
		
	}
	
	//ex10 ����� (����2)
	public void ex11() {
		//������ �� ������ �Է� �ް�
		//�Էµ� ������ �հ� ���
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.print("�Է� ���� ������ �� ���� : ");
		int aNum = sc.nextInt();
		
		for(int i = 1 ; i <= aNum ; i++ ) {
			System.out.print("���� �Է� " + i + " : ");
			int num = sc.nextInt(); 
			
			sum += num;
			
		}
		
		System.out.println("�հ� : " + sum);
		
		
	}
	
	public void ex12() {
		//for - if for - for
		
		//1 ~ 20 1++ print
		//��,5�� ��� () ������ ���
		
		for(int i = 1 ; i <= 20; i++) {
			if(i%5 == 0) {
				System.out.print("(" + i + ") ");
			} else {
				System.out.print(i + " ");
			}
		}
		
		
	}
	
	public void ex13() {
		//1~20 1++ print
		//�� �Է� ���� ���� ����� ()
		Scanner sc = new Scanner(System.in);
		System.out.print("��ȣ�� ǥ���� ��� : ");
		int selet = sc.nextInt();
		
		for(int i = 1 ; i <= 20 ; i++) {
			if(i % selet == 0) {
				System.out.print("("+ i +") ");
			}else {
				System.out.print(i +" ");
			}
		}
		
	}
	
	public void ex14() {
		//if - for
		Scanner sc = new Scanner(System.in);
		//������
		//2~9 �Է¹޾� �ش� �� ���
		//2~9 �ƴϸ� �߸��Է�
		System.out.print("�ش� ���� ���� �Է� : ");
		int num = sc.nextInt();
		
		if(num<2 || num>9) {
			System.out.println("�ش� ���ڴ� �������� �ʽ��ϴ�.");
		} else {
			for( int i = 1; i <= 9 ; i++ ) {
				System.out.printf("%d X %d = %d\n",num,i,num*i);
			}
		}
	}
	
	public void ex15() {
		//19��
		Scanner sc = new Scanner(System.in);
		System.out.print("�ش� ���� �Է����ּ��� : ");
		int ch = sc.nextInt();
		
		if(ch<2 || ch>19) {
			System.out.println("�ش� ���� �������� �ʽ��ϴ�.");
		} else {
			for(int i = 1 ; i <= 19 ; i++) {
				System.out.printf("%2d X %2d = %3d\n",ch,i,ch*i);
			}
		}
		
	}
	
	public void ex16() {
		//��ø for
		for(int dan = 1 ; dan <= 9 ; dan++) {
			System.out.println("");					//�� ����� �ٶ����
			for(int g = 1 ; g <= 9; g++ ) {
				System.out.printf("%2d  X %2d = %2d  ", dan, g, g * dan);
				
			}
		}
	}
	
	public void ex17() {
		//for-for ����
		//������ ���� ���
		for(int dan = 9 ; dan >= 2 ; dan--) {
			System.out.println("");	
			for(int g = 9 ; g >= 1 ; g-- ) {
				System.out.printf("%2d  X %2d = %2d  ", dan, g, g * dan);
				}	
			}
		}
	
	public void ex18() {
		for(int g = 1 ; g<=5 ; g++) {
			System.out.println("");
			for(int s = 1; s<=5 ; s++) {
				System.out.print(s);
			}
		}
	
		System.out.println("");
		
		System.out.println("=============================================");
	
		for(int b = 1; b<=3 ; b++) { 				//�ٹٲ� �ݺ�
			System.out.println("");
			for(int a = 5 ; a>=1 ; a--) { 			//���� ��� ���� �ۼ�
				System.out.print(a);
			}
		}
		System.out.println("");
	}

	public void ex19() {
		//for-for
		//1
		//12
		//123
		//1234
		for(int b = 1 ; b <= 4 ; b++) {
			System.out.println("");
			for(int a = 1 ; a <= b ; a++) {
				System.out.print( a );
			}
		}
		System.out.print("\n=======================================");
		
		for(int d = 4 ; d >= 1 ; d--) {
			System.out.println("");
			for(int c = d ; c >= 1 ; c--) {
				System.out.print(c);
			}
		}
	}
	
	//���� ���� �Ǵ� �м��ɷ� ���
	
	public void ex20() {
		//count 
		//1~20 1++ 
		//last 3�� ����� ���� ���
		
		int count = 0;
		int sum = 0;
		
		for(int i = 1 ; i <=20 ; i++) {
			if(i%3 == 0) {
				System.out.print(i + " ");
				count ++;
				sum += i;
			}
		}
		
		System.out.println(": " + count + "��");
		System.out.println("3�� ����� �հ� : " + sum);
	}
	
	public void ex21() {
		// 1 2 3 4 
 		//	5 6 7 8 
		// 9 10 11 12
		
		//for-for count 
		
		int count = 1;
		
		for(int s = 1 ; s <= 3 ; s++) {
			System.out.println("");
			for(int g = 1 ; g <= 4 ; g++) {
				System.out.printf("%4d",count);
				count++;
			}
		}
	
	
	
	
	}




}
	


