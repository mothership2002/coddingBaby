package edu.kh.variable.practice;

public class CastingPractice {

	public static void main(String[] args) {
		
		int iNum1 = 10 ;
		int iNum2 = 4 ;
		float fNum = 3.0f;
		double dNum = 2.5;
		char ch = 'A';
		
		System.out.println(iNum1 / iNum2);
		
		System.out.println((int)dNum);
		
		System.out.println((double)iNum1);
		System.out.println(dNum * iNum2);
		
		System.out.println((int)fNum);
		System.out.println(iNum1 - iNum2 - (int)fNum);
		System.out.println(iNum1 / (int)fNum);

		System.out.println((double)iNum1/iNum2);
		
		System.out.println(iNum1/fNum);
		System.out.println(iNum1/(double)fNum);
		
		//float 8�ڸ� ���� �� �ݿø�
		//double 16�ڸ� ���� �� ����
		

	}

}
