package edu.kh.basic;

public class JavaTest {
	// class : �ڹ� �ڵ� ���� ����
	
	public static void  main (String[] args) {
		// ���� �޼ҵ� : �ڹ� ���ø����̼��� �����ϱ� ���� �ʿ��� �޼ҵ�
		
		System.out.println("Hello World");
		System.out.println("��ħ���� ��̳���?");
		System.out.println("12345");
		// java �ڵ� �ۼ� -> ���� ( �����Ϸ��� 2������ ��ȯ -> java virtual machine ����) 
		
		System.out.println("--------------------------------");
		
		System.out.println("1 + 2");
		System.out.println(1 + 2);
		
		System.out.println(50 - 23);
		System.out.println(12 * 13);
		System.out.println(327 / 3);
		
		System.out.println("14 * 19 = " + 266);
		System.out.println("14 * 19 = " + 14 * 19);
		
		System.out.println("90 + 70 + 75 = " + 90 + 70 + 75);
		System.out.println("90 + 70 + 75 = " + (90 + 70 + 75));
		
		int A = (int)(Math.random() * 3 + 1);
		System.out.println(A);
		
	}
}
