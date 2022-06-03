package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열1 입력 : ");
		String str1 = sc.nextLine();
		System.out.print("문자열2 입력 : ");
		String str2 = sc.nextLine();
		System.out.print("문자열3 입력 : ");
		String str3 = sc.nextLine();
		
		System.out.printf("%s %s %s\n",str1,str2,str3);

	}

}
