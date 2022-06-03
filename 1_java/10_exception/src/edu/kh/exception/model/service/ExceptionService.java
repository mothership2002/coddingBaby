package edu.kh.exception.model.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionService {
	
	private Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		
		System.out.println("�� ������ �Է� �޾� �������� ���� ��� ");
		
		System.out.print("���� 1 �Է� : ");
		int input1 = sc.nextInt();
		System.out.print("���� 2 �Է� : ");
		int input2 = sc.nextInt();
		
		try {
			System.out.println("��� : "+ input1/input2);
		} catch(ArithmeticException e ) {
			System.out.println("infinity");
		}
		
		
		//�Ϻ� ���� == UnCheckedException (try-catch���)

	}
	
	public int inputNumber() {

		int num = 0;
	
		while(true) {
			try{
				System.out.print("���� �Է� : ");
				num = sc.nextInt();
				sc.nextLine();
				break;
			}catch(InputMismatchException e) {
				System.out.println("�߸� �Է�, ������ �Է�");
				sc.nextLine();
			}
		}
		return num;
		
	}
	public void ex2() {
		int sum = 0; 
		
		for(int i=0; i<3;i++) {
			sum += inputNumber();
		}
		System.out.println("�հ� : "+ sum);
	}

	public void ex3() {
		try {
			System.out.print("�Է�1 : ");
			int num1 = sc.nextInt();
				//InputMismatchException
			System.out.print("�Է�2 : ");
			int num2 = sc.nextInt();
	
			System.out.println("��� : " + (num1/num2));
				//ArithemticException
		}catch(ArithmeticException e) {
			System.out.println("0���� ���� �� ��");
		}catch(InputMismatchException e) {
			System.out.println("������ �Է� ����");
		}
		
	}
	
	public void ex4() {
		//try - catch - finally
		try {
			System.out.println(4/0);
			
		}catch(ArithmeticException e ) {
			System.out.println("���� ó��");
			System.out.println(e.getClass());
			//� ���� Ŭ����
			System.out.println(e.getMessage());
			//���� �߻� �� ��� �Ž���
			System.out.println(e);
			
			e.printStackTrace();
			//���ܰ� �߻��ϱ������ �޼ҵ� ���� ���
		}finally {
			System.out.println("������ ����");
		}
		
		
		// catch �Ű����� ���
		
		
		
	}
	
//	====================================================
	
	public void ex5() {
		//throws ���� �޼ҵ忡 ���ܰ��� ���ѱ�
		//throw  ���ܸ� ���� �߻� (���� �޼ҵ忡 ���ܰ� ����)
		try {
			methodA();
		}catch(Exception e) {
			System.out.println("����");
			e.printStackTrace();
		}
	}
	
	public void methodA() throws IOException {
		
		methodB();
	}
	
	public void methodB() throws IOException {
		
		methodC();
	
	}
	
	public void methodD() {
		
		throw new RuntimeException();
		//CheckedException
		//-RuntimeException���� ���� 
		//�ý����� �浹 �Ǵ� ����
		//if���� ���� �ܼ��ڵ�δ� �ذ� �Ұ�

		
		//UnCheckedException
		//-RuntimeException ����� �Է� ����, �ε��������ʰ�,etc
		//�������� �ڵ� �Ǽ� , ������� �Է� �� ����
		//if�����ε� �ذᰡ��
		//try catch throw���ʿ�X
		
	}
	
	public void methodC() throws IOException {
		
		//throws ioexception == IOException ���ɼ� ��
		//UnCheckedException ���������� ����ó�� ����
		
		throw new IOException();
		
	}
	
}
