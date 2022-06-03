package edu.kh.array.practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	
	public void practice1() {
		/*
		 *  길이가 9인 배열을 선언 및 할당하고,
		 *  1부터 9까지의 값을 반복문을 이용하여
			순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
			짝수번째 인덱스 값의 합을 출력하세요. (0 번째인덱스는짝수로취급)
			[실행화면]
			1 2 3 4 5 6 7 8 9	
			짝수번째 인덱스 합: 25
		 */
		int sum = 0;
		int[] arr = new int[9];
		for(int i=0;i<arr.length;i++) {
			arr[i] = i+1;
			if(i%2==0) {
				sum += arr[i];
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("짝수번째 인덱스의 합 : " + sum);
		
	}
	
	public void practice2() {
		/*  길이가 9인 배열을 선언 및 할당하고 ,
		 * 	9부터 1까지의 값을 반복문을 이용하여
			순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
			홀수번째 인덱스 값의 합을 출력하세요. (0 번째인덱스는짝수로취급)
		 */
		int sum = 0;
		int[] arr = new int[9];
		for(int i=arr.length-1;i>=0;i--) {
			arr[i] = i+1;
			if(i%2!=0) {
				sum += arr[i];
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("홀수번째 인덱스의 합 : " + sum);
		
	}

	public void practice3() {
		/*	사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
			1부터 입력 받은 값까지 배열에 초기화 한 후 출력하세요.
			[실행화면]
			양의정수: 5
			1 2 3 4 5 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=i+1;
		}
		System.out.println(Arrays.toString(arr));
		
	}
	
	public void practice4() {
		/*
		 * 	정수 5개를 입력받아 배열을 초기화하고
			검색할 정수를 하나 입력받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
			배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
		 */
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			System.out.printf("입력 %d : ",i);
			int input = sc.nextInt();
			arr[i] = input;
		}
		boolean flag = false;
		System.out.print("검색할 값 : ");
		int find = sc.nextInt();
		
		for(int i=0;i<arr.length;i++) {
			if(find==arr[i]) {
				System.out.printf("%d번 인덱스에 존재함\n",i);
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("해당 값은 존재하지 않습니다.");
		}
	}
	
	public void practice5() {
		/*	문자열을 입력 받아 문자 하나하나를 배열에
		 *  넣고 검색할 문자가 문자열에 몇개 들어가 있는 지
			개수 와 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.
			[실행화면]
			문자열: application
			문자: i
			application에 i가 존재하는 위치(인덱스) : 4 8
			i개수: 2
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String input = sc.nextLine();
		
		System.out.print("찾을 문자 : ");
		char find = sc.next().charAt(0);
		
		String str = "";
		
		int sum = 0;
		
		char[] arr = new char[input.length()];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = input.charAt(i);
			if(arr[i]==find) {
				sum++;
				str += i+" ";
			}
		}
		System.out.printf("%s 문자열에 %s(이)가 존재하는 인덱스 위치 : %s\n",input,find,str);
		System.out.printf("%s의 개수 : %d\n",find,sum);
		
	}
	
	public void practice6() {
		/*	사용자가 배열의 길이를 직접 입력하여 그 값 만큼 정수형 배열을 선언 및 할당하고
			배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
			그리고 배열 전체값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
			[실행화면]
			정수: 5
			배열 0번째 인덱스에 넣을 값: 4
			배열 1번째 인덱스에 넣을 값: -4
			배열 2번째 인덱스에 넣을 값: 3
			배열 3번째 인덱스에 넣을 값: -3
			배열 4번째 인덱스에 넣을 값: 2
			4 -4 3 -3 2
			총합: 2
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		int sum =0;
		for(int i=0;i<arr.length;i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ",i);
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("총합 : "+sum);
	}
	
	public void practice7() {
		/*
		 * 	주민등록번호 번호를 입력받아 char 배열에 저장한 후 출력하세요.
			단, char 배열 저장시 성별을 나타내는 숫자 이후부터 *로 저장하세요.
			[실행화면]
			주민등록번호(-포함) : 123456-1234567
			123456-1******
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호 입력(-포함) : ");
		String pn = sc.next();
		char[] arr = new char[14];
		for(int i=0;i<arr.length;i++) {
			if(i<8) {
				arr[i] = pn.charAt(i);
			}else {
				arr[i] = '*';
			}
		}
		System.out.println(arr);
		
		
	}
	
	public void practice8() {
		/*	3 이상 인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 
		 * 	값을 넣고,
			중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
			단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력 하세요” 를 출력하고
			다시 정수를 받도록 하세요.
		 * 
		 * 정수: 4
		 * 다시입력하세요.
		 * 정수: -6
		 * 다시입력하세요.
		 * 정수: 5				0123456	012345678
		 * 1, 2, 3, 2, 1		1234321 123454321
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		while(num<3||num%2==0) {
			System.out.println("다시 입력하세요.");
			System.out.print("정수 : ");
			num = sc.nextInt();
		}
		int[] arr = new int[num];
		for(int i=0;i<arr.length;i++) {
			if(i<=num/2) {
				arr[i]=i+1;
			}else {
				arr[i]=arr[num-i-1];
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void practice9() {
		/*	10개의 값을 저장 할 수 있는 정수형 배열을 선언 및 할당하고,
			1~10 사이의 난수를 발생시켜 배열에 초기화 한 후 출력하세요.
			[실행화면]
			발생한난수: 9 7 6 2 5 10 7 2 9 6
		 */
		int[] arr = new int[10];

		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10+1);
		}
		System.out.println("발생한 난수 : "+Arrays.toString(arr));
	}
	
	public void practice10() {
		/*	10개의 값을 저장 할 수 있는 정수형 배열을 선언 및 할당하고,
			1~10 사이의 난수를 발생시켜 배열에 초기화 후
			배열 전체 값과 그 값 중에서 최대 값과 최소 값을 출력하세요.
			[실행화면]
			발생한난수: 5 3 2 7 4 8 6 10 9 10
			최대값: 10
			최소값: 2
		*/
		
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*10+1);
		}
		int max = arr[0];
		int min = arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}else if(arr[i]<min) {
				min = arr[i];
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("최대값 : "+ max);
		System.out.println("최소값 : "+ min);
		
	}
	
	public void practice11() {
		/*  메소드명: public void practice11(){}
			10개의 값을 저장 할 수 있는 정수형 배열을 선언 및 할당하고
			1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요.
			[실행화면]
			4 1 3 6 9 5 8 10 7 2
			*/
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10+1);
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					i--;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void practice12() {
		/* 	메소드명: public void practice12(){}
			로또번호 자동 생성 프로그램 만들기.
			(중복값 없이 오름차순으로 정렬하여 출력하세요.)
			[실행화면]
			3 4 15 17 28 40
		*/
		int arr[]= new int[6];
		for(int i=0;i<arr.length;i++) {
			//로또는 45번까지
			arr[i]=(int)(Math.random()*45+1);
			for(int j=0;j<i;j++) {
				if(arr[j]==arr[i]) {
					i--;
				}
			}
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void practice13() {
		/*  메소드명: public void practice13(){}
			문자열을 입력 받아 문자열에 어떤 문자가 들어 갔는지 배열에 저장하고
			문자의 개수와 함께 출력하세요.
			[실행화면]
			문자열: application
			문자열에있는문자: a, p, l, i, c, t, o, n
			문자개수: 8
		*/
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String word = sc.next();
		
		String str = "";

		char[] arr = new char[word.length()];
		
		int a = word.length() ;
		
		for(int i=0;i<word.length();i++) {
			arr[i] = word.charAt(i);
		}
		
		char[] arr2 = Arrays.copyOf(arr,arr.length);
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr2[i]==arr2[j]) {
					arr2[i] =' ';
					}
			}
			if(arr2[i]==' ') {
					a--;
			}else {
				if(arr2[i]!=arr2[arr.length-1]) {
					str += arr2[i]+", ";
				}else {
					str += arr2[i];
				}
			}
		}
		System.out.println("문자열에 있는 문자 : " + str);
		System.out.println("문자 개수 : " + a);
	}
	
	public void practice14() {
		/*  사용자가 입력한 배열의 길이 만큼의 문자열 배열을 선언 및 할당하고
			배열의 인덱스에 넣을 값 역시 사용자가 입력하여 초기화 하세요.
			단, 사용자에게 배열에 값을 더 넣을지 물어 보고 몇개를 더 입력할건지,
			늘린곳에 어떤 데이터를 넣을 것인지 받으세요.
			사용자가 더 이상 입력하지 않겠다고 하면 배열 전체값을 출력하세요.
		*/
		
		//scanner problem
		
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력 : ");
		int size = sc.nextInt();
		sc.nextLine();
		
		String[] arr = new String[size];

		int start = 0;
		
		while (true) {
			for(int i=start;i<arr.length;i++) {
				System.out.printf("%d번째 문자열 : ",i+1);
				arr[i] = sc.nextLine();
			}
			
			System.out.print("입력을 더 하시겠습니까? (y/n) : ");
			char ch = sc.nextLine().charAt(0);
			
			if(ch == 'y' ||ch == 'Y') {
				start = arr.length;
				System.out.print("몇 개를 더 입력하겠습니까? : ");
				int addsize = sc.nextInt();
				sc.nextLine();
				
				String[] copyArr = new String[arr.length+addsize];
				
				copyArr = Arrays.copyOf(arr, arr.length+addsize);
				
				//for(int i=0 ; i<arr.length ; i++) { // 기존 배열 크기 만큼만 반복

	//				copyArr[i] = arr[i]; // 복사 배열에 기존 배열 값을 같은 인덱스에 대입
//				}
				
				arr = copyArr;
				
			} else {
				break;
			}
			
		}
		System.out.println(Arrays.toString(arr));
		
	}
}

