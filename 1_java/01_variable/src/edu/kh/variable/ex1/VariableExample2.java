package edu.kh.variable.ex1;

public class VariableExample2 {

	public static void main(String[] args) {
		
		/* JAVA �⺻ �ڷ��� 8����
		 * 
		 * boolean : ���� 1byte
		 * 
		 * byte		1 : ������
		 * short	2
		 * int		4
		 * long		8
		 * 
		 * float	4 : �Ǽ��� 
		 * double	8
		 * 
		 * char		2
		 * 
		 * String	������
		 */
		
		// ���� ���� : �޸𸮿� ���� ������ ���� �Ҵ�
		
		boolean BooleanData = true ;
		// �޸𸮿� ������ ������ ���� 1byte �Ҵ�
		// �Ҵ�� �޸𸮸� BooleanDate�� ����
		System.out.println("BooleanData : " + BooleanData);
		
		byte bNum = 127 ;
		System.out.println("bNum = " + bNum);
		
		short sNum = 32767 ;
		System.out.println("sNum = " + sNum);
		
		int iNum = 2147483647 ;
		System.out.println("iNum = " + iNum);
		// ���ͷ� : ������ ���Եǰų� �ۼ� �Ǿ����� �� �� ��ü
		// + ���ͷ� ǥ����� �ڷ������� ���� �ٸ�
		
		long lNum = 10000000000l ;
		System.out.println("lNum = " + lNum);
		
		float fNum = 1.02f ;
		System.out.println("fNum = " + fNum);
		
		double dNum = 3.32323 ;
		System.out.println("dNum = " + dNum);
		
		char ch = '��';
		System.out.println("char = " + ch);
		
		char ch1 = 66;
		System.out.println("char1 = " + ch1);
		
		//���� ��� ��Ģ
		//1. ��ҹ��� ���� , �������� X
		//2. ����� ��� X
		//3. ���ڷ� ���� �Ұ��� 
		//4. Ư������ $ _ ��� ���� ������ ��� X
		//5. ī��ǥ��� ����
		
		System.out.println("------------------");
		
		int A = 10;
		A = 20;
		//�ʱ�ȭ
		
		/* ��� :
		 * - ������ ������
		 * - �ѹ� �Է� �� ���� �Ұ���
		 * - �ڷ��� �� final Ű���� �ۼ�
		 * - ����� ��� �빮�ڷ� �ۼ�, �� �ܾ� �ۼ� �� '_' ���
		 * 
		 * ������ �ʴ� ���� ����
		 * Ư���� ���� �ǹ̺ο�
		 * 
		 */
		
		final double PI_VALUE = 3.141592;
		
		System.out.println( 1 + 1.1 );
		
		int x = 1;
		double y = 1.3;
		System.out.println( x + y );
		
	}

}
