package edu.kh.variable.ex1;

public class VariableExample4 {

	public static void main(String[] args) {
		
		
		/* ���� �� ��ȯ
		 * ���� �ڷ����� ���ϴ� �ڷ������� ���� ��ȯ
		 * 1)ū ������ �ڷ����� ���� ������ �ڷ������� ��ȯ �Ϸ� �Ҷ�
		 * 2)��µǴ� ������ ǥ�⸦ ��ȯ��Ű�� ������
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
		System.out.println(iNum3 + "��° ���� : " + (char)iNum3);
		
		//a ���� 10ĭ �� ����
		
		char ch4 = 'a';
		System.out.println((char)(ch4 + 10));
	}

}
