package edu.kh.array.practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	
	public void practice1() {
		/*
		 *  ���̰� 9�� �迭�� ���� �� �Ҵ��ϰ�,
		 *  1���� 9������ ���� �ݺ����� �̿��Ͽ�
			������� �迭�� �� �ε��� ��ҿ� �����ϰ� ����� ��
			¦����° �ε��� ���� ���� ����ϼ���. (0 ��°�ε�����¦�������)
			[����ȭ��]
			1 2 3 4 5 6 7 8 9	
			¦����° �ε��� ��: 25
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
		System.out.println("¦����° �ε����� �� : " + sum);
		
	}
	
	public void practice2() {
		/*  ���̰� 9�� �迭�� ���� �� �Ҵ��ϰ� ,
		 * 	9���� 1������ ���� �ݺ����� �̿��Ͽ�
			������� �迭�� �� �ε��� ��ҿ� �����ϰ� ����� ��
			Ȧ����° �ε��� ���� ���� ����ϼ���. (0 ��°�ε�����¦�������)
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
		System.out.println("Ȧ����° �ε����� �� : " + sum);
		
	}

	public void practice3() {
		/*	����ڿ��� �Է� ���� ���� ������ŭ �迭 ũ�⸦ �Ҵ��ϰ�
			1���� �Է� ���� ������ �迭�� �ʱ�ȭ �� �� ����ϼ���.
			[����ȭ��]
			��������: 5
			1 2 3 4 5 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=i+1;
		}
		System.out.println(Arrays.toString(arr));
		
	}
	
	public void practice4() {
		/*
		 * 	���� 5���� �Է¹޾� �迭�� �ʱ�ȭ�ϰ�
			�˻��� ������ �ϳ� �Է¹޾� �迭���� ���� ���� �ִ� �ε����� ã�� ���.
			�迭�� ���� ���� ���� ��� ����ġ�ϴ� ���� �������� �ʽ��ϴ١� ���
		 */
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			System.out.printf("�Է� %d : ",i);
			int input = sc.nextInt();
			arr[i] = input;
		}
		boolean flag = false;
		System.out.print("�˻��� �� : ");
		int find = sc.nextInt();
		
		for(int i=0;i<arr.length;i++) {
			if(find==arr[i]) {
				System.out.printf("%d�� �ε����� ������\n",i);
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("�ش� ���� �������� �ʽ��ϴ�.");
		}
	}
	
	public void practice5() {
		/*	���ڿ��� �Է� �޾� ���� �ϳ��ϳ��� �迭��
		 *  �ְ� �˻��� ���ڰ� ���ڿ��� � �� �ִ� ��
			���� �� �� ��° �ε����� ��ġ�ϴ��� �ε����� ����ϼ���.
			[����ȭ��]
			���ڿ�: application
			����: i
			application�� i�� �����ϴ� ��ġ(�ε���) : 4 8
			i����: 2
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� : ");
		String input = sc.nextLine();
		
		System.out.print("ã�� ���� : ");
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
		System.out.printf("%s ���ڿ��� %s(��)�� �����ϴ� �ε��� ��ġ : %s\n",input,find,str);
		System.out.printf("%s�� ���� : %d\n",find,sum);
		
	}
	
	public void practice6() {
		/*	����ڰ� �迭�� ���̸� ���� �Է��Ͽ� �� �� ��ŭ ������ �迭�� ���� �� �Ҵ��ϰ�
			�迭�� ũ�⸸ŭ ����ڰ� ���� ���� �Է��Ͽ� ������ �ε����� ���� �ʱ�ȭ �ϼ���.
			�׸��� �迭 ��ü���� �����ϰ� �� �ε����� ����� ������ ���� ����ϼ���.
			[����ȭ��]
			����: 5
			�迭 0��° �ε����� ���� ��: 4
			�迭 1��° �ε����� ���� ��: -4
			�迭 2��° �ε����� ���� ��: 3
			�迭 3��° �ε����� ���� ��: -3
			�迭 4��° �ε����� ���� ��: 2
			4 -4 3 -3 2
			����: 2
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		int sum =0;
		for(int i=0;i<arr.length;i++) {
			System.out.printf("�迭 %d��° �ε����� ���� �� : ",i);
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("���� : "+sum);
	}
	
	public void practice7() {
		/*
		 * 	�ֹε�Ϲ�ȣ ��ȣ�� �Է¹޾� char �迭�� ������ �� ����ϼ���.
			��, char �迭 ����� ������ ��Ÿ���� ���� ���ĺ��� *�� �����ϼ���.
			[����ȭ��]
			�ֹε�Ϲ�ȣ(-����) : 123456-1234567
			123456-1******
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ �Է�(-����) : ");
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
		/*	3 �̻� �� Ȧ���� �Է� �޾� �迭�� �߰������� 1���� 1�� �����Ͽ� ������������ 
		 * 	���� �ְ�,
			�߰� ���ĺ��� �������� 1�� �����Ͽ� ������������ ���� �־� ����ϼ���.
			��, �Է��� ������ Ȧ���� �ƴϰų� 3 �̸��� ��� ���ٽ� �Է� �ϼ��䡱 �� ����ϰ�
			�ٽ� ������ �޵��� �ϼ���.
		 * 
		 * ����: 4
		 * �ٽ��Է��ϼ���.
		 * ����: -6
		 * �ٽ��Է��ϼ���.
		 * ����: 5				0123456	012345678
		 * 1, 2, 3, 2, 1		1234321 123454321
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		while(num<3||num%2==0) {
			System.out.println("�ٽ� �Է��ϼ���.");
			System.out.print("���� : ");
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
		/*	10���� ���� ���� �� �� �ִ� ������ �迭�� ���� �� �Ҵ��ϰ�,
			1~10 ������ ������ �߻����� �迭�� �ʱ�ȭ �� �� ����ϼ���.
			[����ȭ��]
			�߻��ѳ���: 9 7 6 2 5 10 7 2 9 6
		 */
		int[] arr = new int[10];

		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10+1);
		}
		System.out.println("�߻��� ���� : "+Arrays.toString(arr));
	}
	
	public void practice10() {
		/*	10���� ���� ���� �� �� �ִ� ������ �迭�� ���� �� �Ҵ��ϰ�,
			1~10 ������ ������ �߻����� �迭�� �ʱ�ȭ ��
			�迭 ��ü ���� �� �� �߿��� �ִ� ���� �ּ� ���� ����ϼ���.
			[����ȭ��]
			�߻��ѳ���: 5 3 2 7 4 8 6 10 9 10
			�ִ밪: 10
			�ּҰ�: 2
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
		System.out.println("�ִ밪 : "+ max);
		System.out.println("�ּҰ� : "+ min);
		
	}
	
	public void practice11() {
		/*  �޼ҵ��: public void practice11(){}
			10���� ���� ���� �� �� �ִ� ������ �迭�� ���� �� �Ҵ��ϰ�
			1~10 ������ ������ �߻����� �ߺ��� ���� ���� �迭�� �ʱ�ȭ�� �� ����ϼ���.
			[����ȭ��]
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
		/* 	�޼ҵ��: public void practice12(){}
			�ζǹ�ȣ �ڵ� ���� ���α׷� �����.
			(�ߺ��� ���� ������������ �����Ͽ� ����ϼ���.)
			[����ȭ��]
			3 4 15 17 28 40
		*/
		int arr[]= new int[6];
		for(int i=0;i<arr.length;i++) {
			//�ζǴ� 45������
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
		/*  �޼ҵ��: public void practice13(){}
			���ڿ��� �Է� �޾� ���ڿ��� � ���ڰ� ��� ������ �迭�� �����ϰ�
			������ ������ �Բ� ����ϼ���.
			[����ȭ��]
			���ڿ�: application
			���ڿ����ִ¹���: a, p, l, i, c, t, o, n
			���ڰ���: 8
		*/
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� : ");
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
		System.out.println("���ڿ��� �ִ� ���� : " + str);
		System.out.println("���� ���� : " + a);
	}
	
	public void practice14() {
		/*  ����ڰ� �Է��� �迭�� ���� ��ŭ�� ���ڿ� �迭�� ���� �� �Ҵ��ϰ�
			�迭�� �ε����� ���� �� ���� ����ڰ� �Է��Ͽ� �ʱ�ȭ �ϼ���.
			��, ����ڿ��� �迭�� ���� �� ������ ���� ���� ��� �� �Է��Ұ���,
			�ø����� � �����͸� ���� ������ ��������.
			����ڰ� �� �̻� �Է����� �ʰڴٰ� �ϸ� �迭 ��ü���� ����ϼ���.
		*/
		
		//scanner problem
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�迭�� ũ�⸦ �Է� : ");
		int size = sc.nextInt();
		sc.nextLine();
		
		String[] arr = new String[size];

		int start = 0;
		
		while (true) {
			for(int i=start;i<arr.length;i++) {
				System.out.printf("%d��° ���ڿ� : ",i+1);
				arr[i] = sc.nextLine();
			}
			
			System.out.print("�Է��� �� �Ͻðڽ��ϱ�? (y/n) : ");
			char ch = sc.nextLine().charAt(0);
			
			if(ch == 'y' ||ch == 'Y') {
				start = arr.length;
				System.out.print("�� ���� �� �Է��ϰڽ��ϱ�? : ");
				int addsize = sc.nextInt();
				sc.nextLine();
				
				String[] copyArr = new String[arr.length+addsize];
				
				copyArr = Arrays.copyOf(arr, arr.length+addsize);
				
				//for(int i=0 ; i<arr.length ; i++) { // ���� �迭 ũ�� ��ŭ�� �ݺ�

	//				copyArr[i] = arr[i]; // ���� �迭�� ���� �迭 ���� ���� �ε����� ����
//				}
				
				arr = copyArr;
				
			} else {
				break;
			}
			
		}
		System.out.println(Arrays.toString(arr));
		
	}
}

