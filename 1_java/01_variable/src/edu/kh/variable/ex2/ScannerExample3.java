package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ�1 �Է� : ");
		String str1 = sc.nextLine();
		System.out.print("���ڿ�2 �Է� : ");
		String str2 = sc.nextLine();
		System.out.print("���ڿ�3 �Է� : ");
		String str3 = sc.nextLine();
		
		System.out.printf("%s %s %s\n",str1,str2,str3);

	}

}
