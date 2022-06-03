package edu.kh.op.practice;

import java.util.Scanner;

public class OpPractice {

	public void practice1(){
	
		Scanner sc = new Scanner(System.in);
		System.out.print("사람이 몇 명 있나요 ? : ");
		int human = sc.nextInt();
		System.out.print("사탕은 몇 개 있나요 ? : ");
		int candy = sc.nextInt();
		
		System.out.println("1인당 배정 받는 사탕 수 : " + candy/human);
		System.out.println("남은 사탕 수 : " + candy%human);
		
	}
	public void practice2(){

		 Scanner sc = new Scanner(System.in);
		 System.out.print("이름 : ");
		 String name = sc.next();
		 
		 System.out.print("학년 : ");
		 int age = sc.nextInt();
		 
		 System.out.print("반 : ");
		 int cl = sc.nextInt();
		 
		 System.out.print("번호 : ");
		 int num = sc.nextInt();
		 
		 System.out.print("성별 : ");
		 String str1 =sc.next();
		 
		 System.out.print("평균 성적: ");
		 double point = sc.nextDouble();
		 
		 System.out.printf
		 ("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다.",age,cl,num,name,str1,point);
		 
	 }
	public void practice3(){
		//정수 하나를 입력받아 짝홀수 구분 0은 짝수
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		System.out.println(sc.nextInt()/2 == 0 ? "짝수입니다.":"홀수입니다.");
		
			
	}
	public void practice4(){
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수 입력 : ");
		int kor = sc.nextInt();
		System.out.print("수학 점수 입력 : ");
		int math = sc.nextInt();
		System.out.print("영어 점수 입력 : ");
		int eng = sc.nextInt();
		
		double avg = (kor+math+eng)/3.0;
		String pass = kor>=40 && math>=40 && eng>=40 && avg>=60 ? "합격" : "불합격";
		System.out.println("평균 점수 : " + avg);
		System.out.println(pass);
	}

}
