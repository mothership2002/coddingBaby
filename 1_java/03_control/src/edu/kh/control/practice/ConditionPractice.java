package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {
	
	public void practice1() {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("해당 정수 입력 : ");
		int input = sc.nextInt();
		
		String result;
		
		if(input<=0) {
			result = "양수만 입력해 주세요.";
		} else {
			if(input%2 != 0 )	{
				result = "홀수 입니다.";
			}else {
				result = "짝수 입니다.";
			}
		}
		System.out.println(result);
		

	}
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 성적 입력 : ");
		int kor = sc.nextInt();
		System.out.print("영어 성적 입력 : ");
		int eng = sc.nextInt();
		System.out.print("수학 성적 입력 : ");
		int mat = sc.nextInt();
		
		int sum = kor + eng + mat;
		double avg = sum / 3;
		
		String result;
		
		if(avg>=60) {
			if(kor<40||eng<40||mat<40){
				result = "불합격 입니다.";
			}else {				
				System.out.println("국어 : " + kor);
				System.out.println("영어 : " + eng);
				System.out.println("수학 : " + mat);
				System.out.println("합계 : " + sum);
				System.out.printf("평균 : %.2f",avg);
				result = "축하합니다. 합격입니다!";
			}
		}else {
			result = "불합격 입니다.";
		}
		System.out.println(result);
		
		
		
	}
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("해당 월 입력 : ");
		int month = sc.nextInt();
		
		if(month <= 0 || month >12) {
			System.out.println("해당 숫자의 달은 존재하지 않습니다.");
		}else {
			if(month == 1 || month == 3 || month == 5 
		|| month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.printf("%d월은 31일 까지 있습니다.\n",month);
			}else {
				System.out.printf("%d월은 30일 까지 있습니다.\n",month);
			}	
		}
		
	}
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("신장(m)을 입력해 주세요. : ");
		double high = sc.nextDouble();
		System.out.print("체중(kg)을 입력해 주세요. : ");
		double weigh = sc.nextDouble();
		double bmi = weigh/(high*high);
		String ans;
		if(bmi>=30) {
			ans = "고도 비만";
		} else {
			if(bmi>=25) {
				ans = "비만";
			} else {
				if(bmi>=23) {
					ans = "과체중";
				} else {
					if(bmi>=18.5) {
						ans = "정상 체중";
					}else {
						ans = "저체중";
					}
				}
			}
		}
		System.out.println("BMI : "+bmi);
		System.out.println(ans);
		
	}
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("중간 고사 점수 : ");		//20%
		int mt = sc.nextInt();
		System.out.print("기말 고사 점수 : ");		//30%
		int lt = sc.nextInt();
		System.out.print("과제 점수 : ");  			//30%
		int hw = sc.nextInt();
		System.out.print("출석 횟수 : ");			//20 중 6번빠지면 20%
		int ck = sc.nextInt();
		
		double point = mt * 0.2 + lt * 0.3 + hw * 0.3 + ck;
		
		//70점 이상일 경우 Pass, 70점 미만이거나 전체 강의에 30% 이상 결석 시 Fail을 출력하세요
		String result;
		
		if(ck<=14) {
			result = "Fail [출석 횟수 미달] [ "+ ck + " / 20 ]";
		} else {
			if(point<70) {
				result = "중간 고사 점수(20) : " + mt*0.2 + "\n"
						+ "기말 고사 점수(30) : " + lt*0.3 + "\n"
						+ "과제 점수(30) : " + hw*0.3 + "\n"
						+ "출석 횟수(20) : " + (double)ck + "\n"
						+ "총점 : " + point + "\n"
						+ "Fail [점수 미달] ";
			}else {
				result = "중간 고사 점수(20) : " + mt*0.2 + "\n"
						+ "기말 고사 점수(30) : " + lt*0.3 + "\n"
						+ "과제 점수(30) : " + hw*0.3 + "\n"
						+ "출석 횟수(20) : " + (double)ck + "\n"
						+ "총점 : " + point + "\n"
						+ "Pass ";
			}
		}
	
		System.out.println(result);
	}
	
}
