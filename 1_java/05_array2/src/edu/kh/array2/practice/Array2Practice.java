package edu.kh.array2.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Array2Practice {
	
	
	public void practice1() {
		//3행3열짜리 문자열 배열을 선언 및 할당하고
		//인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여
		//“(0, 0)”과 같은 형식으로 저장 후 출력하세요.	
		String[][]	arr = new String[3][3];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				arr[i][j] = "( "+ i +", "+ j+" )";
			}
		}

		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.toString(arr[2]));
		
	}

	public void practice2() {
		// 4행 4열짜리 정수형 배열을 선언 및 할당하고
		// 1) 1 ~ 16까지 값을 차례대로 저장하세요.
		// 2) 저장된 값들을 차례대로 출력하세요.
		int[][] arr = new int[4][4];
		int num = 1;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = num;
				num++;
			}
		}
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.toString(arr[2]));
		System.out.println(Arrays.toString(arr[3]));
	}
	
	public void practice3() {
		int[][] arr = new int[4][4];
		int num = 16;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = num;
				num--;
			}
		}
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.toString(arr[2]));
		System.out.println(Arrays.toString(arr[3]));
		
	}
	
	public void practice4() {
		int[][] arr = new int[4][4];
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr[i].length-1;j++) {
				int random = (int)(Math.random()*10+1);
				arr[i][j]=random;
				arr[i][3] += arr[i][j];
				
			}
		}
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr[i].length-1;j++) {
				arr[3][i] += arr[j][i];
			}
			arr[3][3]+=arr[i][3];
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("%4d",arr[i][j]);
			}
			System.out.println();
		}

		
		
		
	}
	
	public void practice5() {
		//2차원 배열의 행과 열의 크기를 사용자에게 직접 입력 받되, 1~10사이 숫자가 아니면
		//“반드시 1~10 사이의 정수를 입력해야 합니다.” 출력 후 다시 정수를 받게하세요.
		//크기가 정해진 이차원 배열 안에는 영어 대문자가 랜덤으로 들어가게 한 뒤 출력하세요.
		//(char형은 숫자를 더해서 문자를 표현 할 수 있고 65는 A를 나타냄, 알파벳은 총 26글자
		Scanner sc = new Scanner(System.in);
		int row;
		int col;
		do{
			System.out.print("행 입력 : ");
			row = sc.nextInt();
			System.out.print("열 입력 : ");
			col = sc.nextInt();
			if((row>10||row<1)||(col>10||col<1)) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
			}
		}while((row>10||row<1)||(col>10||col<1));
		
		char[][] arr = new char[row][col];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				int random = (int)(Math.random()*26+65);
				arr[i][j]=(char)random;
			}
		}
		System.out.println(Arrays.deepToString(arr));
		
	}
	
	public void practice6() {
		//사용자에게 행의 크기를 입력받고 그 수만큼의 반복을 통해 열의 크기도 받아
		//문자형 가변 배열을 선언 및 할당하세요.
		//그리고 각 인덱스에 ‘a’ 부터 총 인덱스의 개수 만큼 하나씩 늘려 저장하고 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 크기 : ");
		int input = sc.nextInt();
		char[][] arr = new char[input][];
		char b = 'a';
		for(int i=0;i<input;i++) {
			System.out.printf("%d열의 크기 : ",i);
			int a = sc.nextInt();
			arr[i] = new char[a];
			for(int j=0;j<a;j++) {
				arr[i][j]= b;
				b++;
			}
		}
		System.out.println(Arrays.deepToString(arr));
		
	}

	public void practice7() {
		//1차원 문자열 배열에 학생 이름 초기화 되어있다.
		//3행 2열짜리 2차원 문자열 배열2개를 새로 선언 및 할당하여
		//학생 이름을 2차원 배열에 순서대로 저장하고 아래와 같이 출력하시오.
		//(첫번째 2차원 배열이 모두 저장된 경우 두번째 2차원 배열에 저장진행)
		
		String[] students= {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
		"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] arr = new String[3][2];
		String[][] arr2 = new String[3][2];
		
		int a = 0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = students[a];
				a++;
			}
			
		}
		
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++) {
				arr2[i][j] = students[a];
				a++;
			}
		}
		
		System.out.println("== 1분단 ==");
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.toString(arr[2]));
		System.out.println("== 2분단 ==");
		System.out.println(Arrays.toString(arr2[0]));
		System.out.println(Arrays.toString(arr2[1]));
		System.out.println(Arrays.toString(arr2[2]));
	}
	
	public void practice8() {
		
		String[] students= {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
		"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] arr = new String[3][2];
		String[][] arr2 = new String[3][2];
		
		int a = 0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = students[a];
				a++;
			}
			
		}
		
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++) {
				arr2[i][j] = students[a];
				a++;
			}
		}
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("찾을 학생의 이름 입력 : ");
		String input = sc.next();
	
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j].equals(input)) {
                    String right = "";
                    if (j == 1) {
                        right = "오른쪽";
                    } else {
                    	right = "왼쪽";
                    }
                    System.out.printf("입력하신 %s 학생은 1분단 %d째줄 %s에 있습니다.\n", 
                    		input,i+1,right);
				}
			}
		}
		
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr2[i][j].equals(input)) {
                    String right = "";
                    if (j == 1) {
                        right = "오른쪽";
                    } else {
                    	right = "왼쪽";
                    }
                    System.out.printf("입력하신 %s 학생은 2분단 %d째줄 %s에 있습니다.\n", 
                    		input,i+1,right);
				}
			}
		}

	}
	
	public void practice9() {
	//	String 2차원 배열 6행6열을 만들고 행의 맨위와 제일 앞열은 각 인덱스를 저장하세요.
	//	그리고 사용자에게 행과 열을 입력받아 해당 좌표의 값을 “X”로 변환해 2차원 배열을 출력하세요.
		String[][] arr = new String[6][6];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=" ";
			}
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("행 입력 : ");
		int row = sc.nextInt();
		System.out.print("열 입력 : ");
		int col = sc.nextInt();
		
		arr[row+1][col+1] = "x";
		
		for(int i=1;i<arr.length;i++) {
			int a = i-1;
			arr[0][i] = Integer.toString(a);
		}
		
		for(int i=1;i<arr.length;i++) {
			int a = i-1;
			arr[i][0] = Integer.toString(a);
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}
	
	public void practice10() {
		
		String[][] arr = new String[6][6];
		
		int end = 0;
		
		for(int x=0;x<arr.length;x++) {
			for(int y=0;y<arr[x].length;y++) {
					arr[x][y]=" ";
				}
		}
		
		for(int i=1;i<arr.length;i++) {
			int a = i-1;
			arr[0][i] = Integer.toString(a);
		}
		
		for(int i=1;i<arr.length;i++) {
			int a = i-1;
			arr[i][0] = Integer.toString(a);
		}
	
		
		while(end != 99) {
		
			Scanner sc = new Scanner(System.in);
			System.out.print("행 입력 : ");
			int row = sc.nextInt();
			end = row;
			
			if(end == 99) {
				break;
			}
			
			System.out.print("열 입력 : ");
			int col = sc.nextInt();
			
			arr[row+1][col+1] = "x";
					
			for(int i=0;i<arr.length;i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
		}
	}
}
