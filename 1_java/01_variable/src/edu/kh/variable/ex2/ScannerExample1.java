package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample1 {
	public static void main(String[] args) {
		
		// Scanner �޼ҵ�
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����1 �Է� : ");
		int input1 = sc.nextInt();
		
		System.out.print("����2 �Է� : ");
		int input2 = sc.nextInt();
		
		System.out.printf("%d + %d = %d\n", input1, input2, input1 + input2);
		
		
	}

}
