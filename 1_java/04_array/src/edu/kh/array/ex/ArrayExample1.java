package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample1 {
		
		/* 배열
		 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것.
		 * - 묶어진 변수들은 하나의 배열명으로 불러짐.
		 * 	 구분은 index를 이용함
		 * 	 (index는 0 부터 시작하는 정수)
		 */
		
	public void ex1() {

		//int[] arr;
		//arr = new int[3];
		int [] arr = new int[] {10,70,20,32,12};
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		int[] random = new int[6];
		for(int i=0; i<random.length; i++) {
			random[i] = (int)(Math.random()*10+1);
			System.out.printf("%d ",random[i]);
		}
		int[] arr1 = new int[8];
		//배열의 핵심은 index(주소값)을 참조하는 것.
		
		System.out.println();
		
		//new 연산자 : heap 메모리 영역에 새로운 공간(배열,객체)을 할당한다.
		
		for(int i=0;i<arr1.length;i++) {
			arr1[i] = (int)(Math.random()*100);
			System.out.print(arr1[i]+" ");
		}
		
		
		
		
	}
	
	public void ex2() {
		//배열 선언 및 할당
		int[] arr = new int[5]; 
		System.out.println("배열의 길이 : "+arr.length);
		
	}
	
	public void ex3() {
		//5명의 신장을 입력받고
		//평균 구하기
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		double[] height = new double[5];
		for(int i=0 ; i<height.length;i++) {
			System.out.print((i+1)+"번 신장 입력 : ");
			height[i] = sc.nextDouble();
			sum += height[i];
		}
		double avg = sum/height.length;
		System.out.println("평균 신장 : "+avg);
	}
	
	public void ex4() {
		//입력받은 인원 수 만큼 점수를 입력 받아 배열에 저장
		//합계 평균 최고 최저
		Scanner sc = new Scanner(System.in);
		System.out.print("대상 수 입력 : ");
		int hc = sc.nextInt();
		int[] score = new int[hc];
		
		int sum = 0;
		
		for(int i=0; i<score.length;i++) {
			System.out.print((i+1)+"번째 점수 입력 : ");
			score[i] = sc.nextInt();
			sum += score[i];

			}
		
		int max = score[0];
		int min = score[0];
		
		for(int i=0; i<score.length; i++) {
			if(max<score[i]) {
				max=score[i];
			}else if(min>score[i]){
				min=score[i];
			}
			
		}
			
		double avg = (double)sum/score.length;
		System.out.println("합계 : "+sum);
		System.out.printf("평균 : %.2f\n",avg);	
		System.out.println("최고점 : "+max);
		System.out.println("최저점 : "+min);
		
	}
	
	public void ex5() {
		char[] arr = new char[5];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = (char)('A'+ i);
		}
		
		//arrays class
		//java-배열과 관련된 기능 클래스
		//해시코드 = 주소값이 변경된 형태
		//syso-Arrays-ctrl+space Arrays.toString
		
		int[] arr2 = new int[6];
		System.out.println(arr);
		System.out.println(Arrays.toString(arr2));
		
		char[] arr3 = {'a','b','c','d','e'};
		
	}
	
	public void ex6() {
		
		String[] arr = {"김밥","서브웨이","햄버거","백반","국밥","파스타"};
		int a = (int)(6*Math.random());
		
		System.out.println(arr[a]);
		
	}
	
	public void ex7() {
		//입력 받은 정수가 배열안 존재 유무 확인
		//if 존재시 인덱스 출력
		
		int[] arr = {100,200,300,400,500,600,700,800,900,1000};
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		boolean flag = false;
		
		for(int i=0; i<arr.length;i++) {
			if(input == arr[i]) {
				System.out.println("해당 정수 "+input+"은 배열의 \n" + (i+1) +"번째에 존재합니다.");
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("해당 정수는 배열에 \n존재하지 않습니다.");
		}
	}
	
	public void ex8() {
		
		String[] arr = {"사과","딸기","키위","바나나","멜론","아보카도",};
		Scanner sc = new Scanner(System.in);
		
		System.out.print("과일 입력 : ");
		String input = sc.next();
		boolean have = false;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i].equals(input)) {
				System.out.println("해당 과일은 "+(i+1)+"번째 배열안에 존재합니다.");
				have = true;
			}
		}
		if(!have) {
			System.out.println("해당 과일은 배열안에 존재하지 않습니다.");
		}
	}

	public void ex9() {
		
		//문자열을 입력 받아 한 글자씩 char에 문자로 저장
		//문자 하나를 입력 받아 일치하는 문자가 char에 존재유무 및 갯수 출력
		//없을경우 출력
		//String.length , String.charAt(index)문자열의 문자별 인덱스값(문자)
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String input = sc.nextLine();
		
		char[] arr = new char[input.length()] ;
		
		boolean flag = false;
		System.out.print("검색할 문자 입력 : ");
		
		char cha = sc.nextLine().charAt(0); //next와 nextline 차이점 - 공란 유무 판별
		
		int a = 0;
		
		for(int i=0; i<input.length();i++) {
			arr[i]=input.charAt(i);
			if(arr[i]==cha) {
				a++;
			}
		}
		
		if(a==0) {
			System.out.println("해당 문자는 입력한 문자열에 존재하지 않습니다.");
		}else {
			System.out.printf("해당 문자는 입력한 문자열에 %d개 존재합니다.\n",a);
		}
		
		
	}













}
