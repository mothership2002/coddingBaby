package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 1 : ");
		String str = sc.next() + " ";
		System.out.println(str);
		
		System.out.print("입력 2 : ");
		str = str + sc.next() + " ";
		System.out.println(str);
		
		System.out.print("입력 3 : ");
		str = str + sc.next();
		System.out.println(str);	
		

	}

}
