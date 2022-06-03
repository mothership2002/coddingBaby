package edu.kh.array2.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Array2Practice {
	
	
	public void practice1() {
		//3��3��¥�� ���ڿ� �迭�� ���� �� �Ҵ��ϰ�
		//�ε��� 0�� 0������ 2�� 2������ ���ʴ�� �����Ͽ�
		//��(0, 0)���� ���� �������� ���� �� ����ϼ���.	
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
		// 4�� 4��¥�� ������ �迭�� ���� �� �Ҵ��ϰ�
		// 1) 1 ~ 16���� ���� ���ʴ�� �����ϼ���.
		// 2) ����� ������ ���ʴ�� ����ϼ���.
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
		//2���� �迭�� ��� ���� ũ�⸦ ����ڿ��� ���� �Է� �޵�, 1~10���� ���ڰ� �ƴϸ�
		//���ݵ�� 1~10 ������ ������ �Է��ؾ� �մϴ�.�� ��� �� �ٽ� ������ �ް��ϼ���.
		//ũ�Ⱑ ������ ������ �迭 �ȿ��� ���� �빮�ڰ� �������� ���� �� �� ����ϼ���.
		//(char���� ���ڸ� ���ؼ� ���ڸ� ǥ�� �� �� �ְ� 65�� A�� ��Ÿ��, ���ĺ��� �� 26����
		Scanner sc = new Scanner(System.in);
		int row;
		int col;
		do{
			System.out.print("�� �Է� : ");
			row = sc.nextInt();
			System.out.print("�� �Է� : ");
			col = sc.nextInt();
			if((row>10||row<1)||(col>10||col<1)) {
				System.out.println("�ݵ�� 1~10 ������ ������ �Է��ؾ� �մϴ�.");
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
		//����ڿ��� ���� ũ�⸦ �Է¹ް� �� ����ŭ�� �ݺ��� ���� ���� ũ�⵵ �޾�
		//������ ���� �迭�� ���� �� �Ҵ��ϼ���.
		//�׸��� �� �ε����� ��a�� ���� �� �ε����� ���� ��ŭ �ϳ��� �÷� �����ϰ� ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ũ�� : ");
		int input = sc.nextInt();
		char[][] arr = new char[input][];
		char b = 'a';
		for(int i=0;i<input;i++) {
			System.out.printf("%d���� ũ�� : ",i);
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
		//1���� ���ڿ� �迭�� �л� �̸� �ʱ�ȭ �Ǿ��ִ�.
		//3�� 2��¥�� 2���� ���ڿ� �迭2���� ���� ���� �� �Ҵ��Ͽ�
		//�л� �̸��� 2���� �迭�� ������� �����ϰ� �Ʒ��� ���� ����Ͻÿ�.
		//(ù��° 2���� �迭�� ��� ����� ��� �ι�° 2���� �迭�� ��������)
		
		String[] students= {"���ǰ�", "������", "�����", "�����", "���̹�", "�ں���",
		"�ۼ���", "������", "������", "��õ��", "��ǳǥ", "ȫ����"};
		
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
		
		System.out.println("== 1�д� ==");
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.toString(arr[2]));
		System.out.println("== 2�д� ==");
		System.out.println(Arrays.toString(arr2[0]));
		System.out.println(Arrays.toString(arr2[1]));
		System.out.println(Arrays.toString(arr2[2]));
	}
	
	public void practice8() {
		
		String[] students= {"���ǰ�", "������", "�����", "�����", "���̹�", "�ں���",
		"�ۼ���", "������", "������", "��õ��", "��ǳǥ", "ȫ����"};
		
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
		System.out.print("ã�� �л��� �̸� �Է� : ");
		String input = sc.next();
	
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j].equals(input)) {
                    String right = "";
                    if (j == 1) {
                        right = "������";
                    } else {
                    	right = "����";
                    }
                    System.out.printf("�Է��Ͻ� %s �л��� 1�д� %d°�� %s�� �ֽ��ϴ�.\n", 
                    		input,i+1,right);
				}
			}
		}
		
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr2[i][j].equals(input)) {
                    String right = "";
                    if (j == 1) {
                        right = "������";
                    } else {
                    	right = "����";
                    }
                    System.out.printf("�Է��Ͻ� %s �л��� 2�д� %d°�� %s�� �ֽ��ϴ�.\n", 
                    		input,i+1,right);
				}
			}
		}

	}
	
	public void practice9() {
	//	String 2���� �迭 6��6���� ����� ���� ������ ���� �տ��� �� �ε����� �����ϼ���.
	//	�׸��� ����ڿ��� ��� ���� �Է¹޾� �ش� ��ǥ�� ���� ��X���� ��ȯ�� 2���� �迭�� ����ϼ���.
		String[][] arr = new String[6][6];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=" ";
			}
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�� �Է� : ");
		int row = sc.nextInt();
		System.out.print("�� �Է� : ");
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
			System.out.print("�� �Է� : ");
			int row = sc.nextInt();
			end = row;
			
			if(end == 99) {
				break;
			}
			
			System.out.print("�� �Է� : ");
			int col = sc.nextInt();
			
			arr[row+1][col+1] = "x";
					
			for(int i=0;i<arr.length;i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
		}
	}
}
