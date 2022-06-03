package edu.kh.control.loop;

import java.util.Scanner;

import org.w3c.dom.css.Counter;

public class ForExample {
	/* for 문
	 * 끝나는 횟수가 정해진 반복문
	 * for(초기식,조건식,증감식){code}
	 * - 초기식 : for문을 제어하는 용도의 변수 선언
	 * - 조건식 : for문의 반복여부를 결정하는 식 (true,false)
	 * 				(보통, 초기식에 사용한 변수를 이용하여 조건문 작성)
	 * - 증감식 : 초기식에 사용된 변수를 for문이 반복 할 때마다 
	 * 				증감시켜 조건식의 결과를 변하게 하는 식.
	 */
	
	public void ex1() {
		for (int i = 1 ; i <= 10 ;  i += 2) {
			System.out.printf("%d\n",i);
			//반복문은 조건식이 true일때만 반복
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
		//1부터 입력받은 수까지 1씩증가
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("마지막에 작성 될 정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i = 1 ; i <= input ; i++) {
			System.out.printf("%d\n",i);
		}
		
	}
	
	public void ex5() {
		//1~input 2++
		Scanner sc = new Scanner(System.in);
		System.out.print("마지막에 작성 될 정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i = 1 ; i <= input ; i += 2) {
			System.out.printf("%d\n",i);
		}
		
	}
	
	public void ex6() {
		//1~input 0.5++
		Scanner sc = new Scanner(System.in);
		System.out.print("마지막에 작성 될 수 입력 : ");
		double input = sc.nextDouble();
		
		for(double i = 1 ; i <= input ; i += 0.5) {
			System.out.printf("%.1f\n",i);
		}
	}
	
	public void ex7() {
		//영어 알파벳r

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
		//for문 심화
		//반복문 사용 값의 누적
		
		//1~10 모든 정수의 합
		int sum = 0 ;
		for(int i = 1 ; i <= 10 ; i ++) {
			sum += i ;
		}
		System.out.println("합계 : " + sum);
	}
	//ex9 어려움 (누적)
	
	public void ex10() {
		//정수 5개
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i = 1 ; i <= 5 ; i++) {
			System.out.print("정수 입력 "+ i + " : ");
			int input = sc.nextInt();
			//{}안에서 생성된 변수는 {}밖에서는 사라짐
			sum += input;
			
		}
		
		System.out.println("합계 : " + sum);
		
		
	}
	
	//ex10 어려움 (누적2)
	public void ex11() {
		//정수의 총 갯수를 입력 받고
		//입력된 정수의 합계 출력
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.print("입력 받을 정수의 총 갯수 : ");
		int aNum = sc.nextInt();
		
		for(int i = 1 ; i <= aNum ; i++ ) {
			System.out.print("정수 입력 " + i + " : ");
			int num = sc.nextInt(); 
			
			sum += num;
			
		}
		
		System.out.println("합계 : " + sum);
		
		
	}
	
	public void ex12() {
		//for - if for - for
		
		//1 ~ 20 1++ print
		//단,5의 배수 () 붙혀서 출력
		
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
		//단 입력 받은 수의 배수는 ()
		Scanner sc = new Scanner(System.in);
		System.out.print("괄호를 표시할 배수 : ");
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
		//구구단
		//2~9 입력받아 해당 단 출력
		//2~9 아니면 잘못입력
		System.out.print("해당 단의 숫자 입력 : ");
		int num = sc.nextInt();
		
		if(num<2 || num>9) {
			System.out.println("해당 숫자는 지원하지 않습니다.");
		} else {
			for( int i = 1; i <= 9 ; i++ ) {
				System.out.printf("%d X %d = %d\n",num,i,num*i);
			}
		}
	}
	
	public void ex15() {
		//19단
		Scanner sc = new Scanner(System.in);
		System.out.print("해당 단을 입력해주세요 : ");
		int ch = sc.nextInt();
		
		if(ch<2 || ch>19) {
			System.out.println("해당 단은 지원하지 않습니다.");
		} else {
			for(int i = 1 ; i <= 19 ; i++) {
				System.out.printf("%2d X %2d = %3d\n",ch,i,ch*i);
			}
		}
		
	}
	
	public void ex16() {
		//중첩 for
		for(int dan = 1 ; dan <= 9 ; dan++) {
			System.out.println("");					//단 종료시 줄띄우기용
			for(int g = 1 ; g <= 9; g++ ) {
				System.out.printf("%2d  X %2d = %2d  ", dan, g, g * dan);
				
			}
		}
	}
	
	public void ex17() {
		//for-for 응용
		//구구단 역순 출력
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
	
		for(int b = 1; b<=3 ; b++) { 				//줄바꿈 반복
			System.out.println("");
			for(int a = 5 ; a>=1 ; a--) { 			//한줄 출력 먼저 작성
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
	
	//센스 유무 판단 분석능력 요망
	
	public void ex20() {
		//count 
		//1~20 1++ 
		//last 3의 배수의 갯수 출력
		
		int count = 0;
		int sum = 0;
		
		for(int i = 1 ; i <=20 ; i++) {
			if(i%3 == 0) {
				System.out.print(i + " ");
				count ++;
				sum += i;
			}
		}
		
		System.out.println(": " + count + "개");
		System.out.println("3의 배수의 합계 : " + sum);
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
	


