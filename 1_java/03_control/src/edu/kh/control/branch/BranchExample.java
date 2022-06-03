package edu.kh.control.branch;

import java.util.Scanner;

public class BranchExample {
	
	public void ex1() {
		// 1 ~ 10 1++ 
		// if 5 print , end
		
		for(int i = 1 ; i <=10 ; i++) {
			System.out.print(i+" ");
			if(i==5) {
				System.out.println("출력을 종료합니다"); break;
			}
		}
	}
	
	public void ex2() {
		
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		int sum = 0;
		
		while(true) {
			System.out.print("정수 입력 : ");
			i = sc.nextInt();
			if(i==0) {
				break;
			}
			sum += i;
			
		}
		System.out.println("합계 : "+sum);
		
	}
	
	public void ex3() {
		
		//exit - end - print
		Scanner sc = new Scanner(System.in);
		String str = "";
		
		while (true) {
			System.out.print("문자열 입력 \n(exit@ 입력 시 종료) : ");
			String input = sc.nextLine();
			if(input.equals("exit@")) {
				break;
			}
			str += input+"\n";
		}
		System.out.println(str);			//str.equals("str") <- == 문자열(참조형)
	}
	
	public void ex4() {
		//중첩 반복문 in break
		//2-2 3-3...9-9
		
		/*loop1*/for(int i=2;i<=9;i++) {
			
			for(int j=1;j<=9;j++) {
				System.out.printf(" %d X %d = %2d ",i,j,i*j);
				if(j==i) {
					break /*loop1*/;
				}
			}
		System.out.println();
		}
		
	}
	
	public void ex5() {
		//continue - 다음 반복으로 넘어감
		//break
		//1~10 1++ %3 = 0 X
		for(int i=1;i<=10;i++) {
			if(i%3==0) {
				continue;
			}
			System.out.print(i+" ");
		}
		
	}
	
	public void ex6() {
		//1~100 1++
		//%5 , 40-end
		for(int i=1;i<=100;i++) {	//우선순위 판별 - 종료조건을 제외조건위로 
			if(i%5==0) {
				continue;
			}else {
				if(i>=40) {
					break;
				}
			}
			System.out.print(i+" ");
			
		}
		
	}
	
	public void rps() {
		//가위바위보
		//판수
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 게임 횟수 : ");
		int game = sc.nextInt();
		
		int w = 0;
		int l = 0;
		int d = 0;
		
		for(int i=1; i<=game; i++) {
			System.out.printf("\n%d번째 게임\n",i);
			System.out.println("가위/바위/보 중 하나를 입력하세요. :");
			String str = sc.next();
			//난수 생성
			//1-s 2-r 3-p
			//switch
			//	Math.random() * 3 + 1;//0.0~1.0난수 생성
			int A = (int)(Math.random() * 3 + 1);
			
			String com;
			
			switch (A){
			case 1 : com = "가위"; break;
			case 2 : com = "바위"; break;
			default : com = "보";		
			}
			
			System.out.printf("컴퓨터는 [%s] 입니다.",com);
			String result = "";
			
			if(str.equals(com)) {
				System.out.print("\n비겼습니다.");
				d += 1 ;
			} else {
				if(str.equals("가위")&&com.equals("바위")) {
						result = "\n졌습니다.";
						l += 1;
				} else if (str.equals("보")&&str.equals("가위")) {
						result = "\n졌습니다.";
						l += 1;
				} else if (str.equals("바위")&&str.equals("보")) {
						result = "\n졌습니다.";	
						l += 1;
				} else {
						result = "\n이겼습니다.";
						w += 1;
				}
			}
			System.out.println(result);
		}
		double rate = w;
		System.out.printf("\n승률은 %.2f%% 입니다.\n",rate/game*100);
		System.out.printf("총 전적은 %d승 %d무 %d패 입니다.\n",w,d,l);
	}

}
