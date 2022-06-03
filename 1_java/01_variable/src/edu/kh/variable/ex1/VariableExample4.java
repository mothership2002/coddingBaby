package edu.kh.variable.ex1;

public class VariableExample4 {

	public static void main(String[] args) {
		
		
		/* 강제 형 변환
		 * 기존 자료형을 원하는 자료형으로 강제 변환
		 * 1)큰 데이터 자료형을 작은 데이터 자료형으로 변환 하려 할때
		 * 2)출력되는 데이터 표기를 변환시키고 싶을때
		 * 
		 * 		double temp = 2.8378
		 * 		int num = (int)temp
		 */
		
		double temp = 3.14;
		int num = (int)temp;
		
		System.out.println(num);
		
		int iNum = 290;
		byte bNum = (byte)iNum;
		
		System.out.println("before : " + iNum);
		System.out.println("after : " + bNum);
		
		char ch1 = 'A';
		int int2 = ch1;
		
		System.out.println("before : " + ch1);
		System.out.println("after : " + int2);
		
		System.out.println("-----------------------");
		
		System.out.println((int)ch1);
		
		
		int iNum3 = 100;
		
		System.out.println((char)iNum3);
		System.out.println(iNum3 + "번째 문자 : " + (char)iNum3);
		
		//a 보다 10칸 뒤 문자
		
		char ch4 = 'a';
		System.out.println((char)(ch4 + 10));
	}

}
