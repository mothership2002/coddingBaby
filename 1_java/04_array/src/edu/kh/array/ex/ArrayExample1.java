package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample1 {
		
		/* �迭
		 * - ���� �ڷ����� ������ �ϳ��� �������� �ٷ�� ��.
		 * - ������ �������� �ϳ��� �迭������ �ҷ���.
		 * 	 ������ index�� �̿���
		 * 	 (index�� 0 ���� �����ϴ� ����)
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
		//�迭�� �ٽ��� index(�ּҰ�)�� �����ϴ� ��.
		
		System.out.println();
		
		//new ������ : heap �޸� ������ ���ο� ����(�迭,��ü)�� �Ҵ��Ѵ�.
		
		for(int i=0;i<arr1.length;i++) {
			arr1[i] = (int)(Math.random()*100);
			System.out.print(arr1[i]+" ");
		}
		
		
		
		
	}
	
	public void ex2() {
		//�迭 ���� �� �Ҵ�
		int[] arr = new int[5]; 
		System.out.println("�迭�� ���� : "+arr.length);
		
	}
	
	public void ex3() {
		//5���� ������ �Է¹ް�
		//��� ���ϱ�
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		double[] height = new double[5];
		for(int i=0 ; i<height.length;i++) {
			System.out.print((i+1)+"�� ���� �Է� : ");
			height[i] = sc.nextDouble();
			sum += height[i];
		}
		double avg = sum/height.length;
		System.out.println("��� ���� : "+avg);
	}
	
	public void ex4() {
		//�Է¹��� �ο� �� ��ŭ ������ �Է� �޾� �迭�� ����
		//�հ� ��� �ְ� ����
		Scanner sc = new Scanner(System.in);
		System.out.print("��� �� �Է� : ");
		int hc = sc.nextInt();
		int[] score = new int[hc];
		
		int sum = 0;
		
		for(int i=0; i<score.length;i++) {
			System.out.print((i+1)+"��° ���� �Է� : ");
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
		System.out.println("�հ� : "+sum);
		System.out.printf("��� : %.2f\n",avg);	
		System.out.println("�ְ��� : "+max);
		System.out.println("������ : "+min);
		
	}
	
	public void ex5() {
		char[] arr = new char[5];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = (char)('A'+ i);
		}
		
		//arrays class
		//java-�迭�� ���õ� ��� Ŭ����
		//�ؽ��ڵ� = �ּҰ��� ����� ����
		//syso-Arrays-ctrl+space Arrays.toString
		
		int[] arr2 = new int[6];
		System.out.println(arr);
		System.out.println(Arrays.toString(arr2));
		
		char[] arr3 = {'a','b','c','d','e'};
		
	}
	
	public void ex6() {
		
		String[] arr = {"���","�������","�ܹ���","���","����","�Ľ�Ÿ"};
		int a = (int)(6*Math.random());
		
		System.out.println(arr[a]);
		
	}
	
	public void ex7() {
		//�Է� ���� ������ �迭�� ���� ���� Ȯ��
		//if ����� �ε��� ���
		
		int[] arr = {100,200,300,400,500,600,700,800,900,1000};
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		boolean flag = false;
		
		for(int i=0; i<arr.length;i++) {
			if(input == arr[i]) {
				System.out.println("�ش� ���� "+input+"�� �迭�� \n" + (i+1) +"��°�� �����մϴ�.");
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("�ش� ������ �迭�� \n�������� �ʽ��ϴ�.");
		}
	}
	
	public void ex8() {
		
		String[] arr = {"���","����","Ű��","�ٳ���","���","�ƺ�ī��",};
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		String input = sc.next();
		boolean have = false;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i].equals(input)) {
				System.out.println("�ش� ������ "+(i+1)+"��° �迭�ȿ� �����մϴ�.");
				have = true;
			}
		}
		if(!have) {
			System.out.println("�ش� ������ �迭�ȿ� �������� �ʽ��ϴ�.");
		}
	}

	public void ex9() {
		
		//���ڿ��� �Է� �޾� �� ���ھ� char�� ���ڷ� ����
		//���� �ϳ��� �Է� �޾� ��ġ�ϴ� ���ڰ� char�� �������� �� ���� ���
		//������� ���
		//String.length , String.charAt(index)���ڿ��� ���ں� �ε�����(����)
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� �Է� : ");
		String input = sc.nextLine();
		
		char[] arr = new char[input.length()] ;
		
		boolean flag = false;
		System.out.print("�˻��� ���� �Է� : ");
		
		char cha = sc.nextLine().charAt(0); //next�� nextline ������ - ���� ���� �Ǻ�
		
		int a = 0;
		
		for(int i=0; i<input.length();i++) {
			arr[i]=input.charAt(i);
			if(arr[i]==cha) {
				a++;
			}
		}
		
		if(a==0) {
			System.out.println("�ش� ���ڴ� �Է��� ���ڿ��� �������� �ʽ��ϴ�.");
		}else {
			System.out.printf("�ش� ���ڴ� �Է��� ���ڿ��� %d�� �����մϴ�.\n",a);
		}
		
		
	}













}
