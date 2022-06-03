package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionExample {
	
	public void ex1() {
		//수업은 if문 본인은 재낌
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input >= 0) {
			if(input ==0) {
				System.out.println("0 입니다.");
			} else {
				System.out.println("양수입니다.");
			}
		} else {
			System.out.println("음수입니다.");
		}
	}
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		//홀짝 검사
	/*	if(input%2 != 0) {
			System.out.println("홀수 입니다.");
		} else {
			System.out.println("짝수 입니다.");
		}
		*/
		if(input%2 == 0 ) {
			if(input == 0) {
				System.out.println("0 입니다.");
			} else {
				System.out.println("짝수입니다.");
			}
		} else {
			System.out.println("홀수입니다.");
		}
	}
	public void ex3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input>0){
			System.out.println("양수입니다.");
		}else if(input == 0){
			System.out.println("0 입니다.");
		}else {
			System.out.println("음수입니다.");
		}
	}
	public void ex4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("해당 월 입력 : ");
		int month = sc.nextInt();
		
		String season; 
				
		if(month >2 && month<=5) {
			season = "봄";
		} else if(month>5 && month<=8) {
			season = "여름";
		} else if(month>8 && month<=11) {
			season = "가을";
		} else if(month == 1 || month == 2 || month == 12){
			season = "겨울";
		} else {
			season = "해당 월은 존재하지 않습니다.";
		}
		
		System.out.println(season);
		
	}
	public void ex5() {
		//나이를 입력받아 13세 이하 - 어린이 입니다.
		//13세 초과 19이하 - 청소년 입니다.
		//19초과 - 성인 입니다.
		Scanner sc = new Scanner(System.in);
		System.out.print("인물의 연령 입력 : ");
		int age = sc.nextInt();
		
		String condition;
		
		if(age <= 13 && age > 0) {
			condition = "어린이 입니다.";
		}else if(age <= 19) {
			condition = "청소년 입니다.";
		}else if(age > 19) {
			condition = "성인 입니다.";
		}else {
			condition = "해당 나이는 존재하지 않습니다.";
		}
		
		System.out.println(condition);
		
	}
	public void ex6() {
		//범위 관련 예제
		//정수를 입력 받은 후 90점 이상 A 
		//80이상 B
		//70이상 C
		//60이상 D
		//60미만 f
		//0 미만 100초과 잘못
		Scanner sc = new Scanner(System.in);
		System.out.print("해당 점수 입력 : ");
		int point = sc.nextInt();
		
		if(point<0 || point >100) {
			System.out.println("해당 점수를 잘못 입력하셨습니다.");
		}else if(point>=90) {
			System.out.println("A");
		}else if(point>=80) {
			System.out.println("B");
		}else if(point>=70) {
			System.out.println("C");
		}else if(point>=60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		
	}
	public void ex7() {

		// 놀이기구 탑승 제한 검사
				// 나이가 12세 이상, 키 140.0cm 이상 일 경우에만 "탑승 가능"
				// 나이가 12미만인 경우 : "적정 연령이 아닙니다."
				// 키가 140.0cm 미만 : "적정 키가 아닙니다."
				// 나이를 0세 미만, 100세 초과 시 : "잘못 입력하셨습니다."
		Scanner sc = new Scanner(System.in);
		System.out.print("해당 인물의 연령 입력 : ");
		int age = sc.nextInt();
		System.out.print("해당 인물의 신장 입력 : ");
		double high = sc.nextDouble();
		
		if(age<0 || age>100) {
			System.out.println("잘못 입력하셨습니다.");
		}else if(high<140.0) {
			System.out.println("적정 키가 아닙니다.");
		}else if(age<12) {
			System.out.println("적정 연령이 아닙니다.");
		}else {
			System.out.println("탑승 가능합니다.");
		}
	
	
	
	}
	public void ex8( ) {
		// 놀이기구 탑승 제한 검사 프로그램 
		   // 조건 - 나이 : 12세 이상
		   //     -  키 : 140.0cm 이상
		   
		   // 나이를 0~100세 사이로 입력하지 않은 경우 : "나이를 잘못 입력 하셨습니다." if1
		   // 키를 0~250.0cm 사이로 입력하지 않은 경우 : "키를 잘못 입력 하셨습니다."	el1
		   // -> 입력이 되자 마자 검사를 진행하여 잘못된 경우 프로그램 종료
		   
		   // 나이 O , 키 X : "나이는 적절하나, 키가 적절치 않음"; else2-2	
		   // 나이 X , 키 O : "키는 적절하나, 나이는 적절치 않음"; if2-2
		   // 나이 X , 키 X : "나이와 키 모두 적절치 않음"; if2-1
		   // 나이 O , 키 O : "탑승 가능"	else2
		Scanner sc = new Scanner(System.in);
		System.out.print("해당 인물의 연령 입력 : ");
		int age = sc.nextInt();
		
		String result ;
		
		if(age>=0 && age<100) {
			System.out.print("해당 인물의 신장 입력 : ");
			double high = sc.nextDouble();
			if(high>250.0 || high < 0) {
				result = "신장을 잘못 입력 하셨습니다.";
			} else {
				if(age < 12 && high < 140.0) {
					result = "나이와 신장 모두 적절치 않음.";
				} else {
					if(age >= 12 && high < 140.0) {
						result = "나이는 적절하나 신장가 적절치 않음.";
					}else if(age <12 && high >= 140.0){
						result = "신장는 적절하나 나이는 적절치 않음.";
					}else {
						result = "탑승 가능";
					}
				}
			}
		} else {
			result = "나이를 잘못 입력 하셨습니다.";
		}
		System.out.println(result);
	
		/* 강사님것
	 *       Scanner sc = new Scanner(System.in);
      
      System.out.print("나이 입력 : ");
      int age = sc.nextInt();
      
      String result;
      
      if(age < 0 || age > 100) {
         result = "나이를 잘못 입력 하셨습니다.";
      
      } else {
         System.out.print("키 입력 : ");
         double height = sc.nextDouble();
         
         if(height < 0  || height > 250) {
            result = "키를 잘못 입력 하셨습니다.";
            
         } else {
            
            if(age < 12 && height >= 140.0) { // 나이 X , 키 O
               result = "키는 적절하나, 나이가 적절치 않음";

            } else if(age >= 12 && height < 140.0) { // 나이 O , 키 X
               result = "나이는 적절하나, 키가 적절치 않음";
               
            } else if(age < 12 && height < 140.0) {
               result = "나이와 키 모두 적절치 않음";
            
            } else {
               result = "탑승 가능";
            }
         }           //핵심은 정리 순서인 것 같다.
      }
      
      System.out.println(result);
      
      
      

	 */

	
	}
	
	
	
	
}
	
