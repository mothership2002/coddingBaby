package edu.kh.variable.ex1;

public class VariableExample3 {

	public static void main(String[] args) {
		/*
		 * ����ȯ 
		 * ���� ���¸� ��ȯ�ϴ� ��
		 * - �� boolean ����
		 * �⺻������ ���� �ڷ������θ� ���� ����
		 * �ٸ� �ڷ����� ���� �� ���� �߻�
		 */
		//Auto Casting
		//- ���� ������ ū �ڷ����� ���� ������ ���� �ڷ����� �����,
		//- ���� �ڷ����� ū �ڷ������� �ڵ� ��ȯ
		
		int num1 = 10 ;
		double num2 = 3.5 ;
		
		System.out.println("�ڵ� �� ��ȯ ��� : " + (num1 + num2));
		//�ڵ� �� ��ȯ���� ���� �ڵ� ����
		
		int i1 = 3;
		double d1 = i1;
		
		System.out.println("i1 = " + i1 );
		System.out.println("d1 = " + d1 );
		
		System.out.println("d1 + num2 = " + (d1 + num2));
		
		// int -> long �� ��ȯ
		int i2 = 2_100_000_000;
		long l2 = 10_000_000_000l;
		
		long result2 = i2 + l2; 
		
		System.out.println("����� : " + result2);
		
		//char -> int �� ��ȯ
		
		char ch3 = 'o';
		int int3 = ch3;
		
		System.out.println("int3 = " + int3); 
		
		char ch4 = '��';
		int int4 = ch4 ;
		
		System.out.println("int4 = " + int4);
		
		//long -> float
		long l5 = 123456789123456789l;
		float f5 = l5 * 100;
		
		//float = int * long
		//float = long * long
		//float = long ���
		//float = float(�ڵ� �� ��ȯ)
		
		System.out.println("f5 = " + f5);
		
		/* �����÷ο�
		 * ��ǻ�ʹ� �ľ� �Ұ��� , �������� ���� ��� ��
		 */
			
		int i6 = 2147483647;
		int result6 = i6 + 1;
		System.out.println("result6 = " + result6);
		
		
		
		
	}

}
