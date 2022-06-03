package edu.kh.variable.ex2;

public class PrintExample {

	public static void main(String[] args) {
		
		System.out.println("�׽�Ʈ1");
		System.out.println("�׽�Ʈ2");
		
		System.out.print("�׽�Ʈ3");
		System.out.println();
		System.out.print("�׽�Ʈ4");
		
		System.out.println("-------------------");
		
		int iNum1 = 10;
		int iNum2 = 5;
		int iNum3 = 2;
		
		System.out.println(iNum1 + " + " + iNum2 + " = " + (iNum1 + iNum2));
		
		System.out.printf("%d + %d = %d\n", iNum1, iNum2, iNum1+iNum2);
		
		System.out.println(iNum1 + " + " + iNum1 + " * " + iNum2 + " / "+ iNum3
				+ " = "	+ (iNum1+iNum1*iNum2/iNum3));
		
		System.out.printf("%d + %d * %d / %d = %d\n", 
				iNum1, iNum1, iNum2, iNum3, iNum1+iNum1*iNum2/iNum3);
		
		/* %d ������ %o 8���� %x 16����
		 * %c ���� 	 %s ���ڿ�
		 * %f �Ǽ� 	 %e ��������
		 * %g ���� �� �״��
		 * %A 16���� �Ǽ�
		 * %b ����
		 */
		
		int iNum4 = 3;
		
		System.out.printf("%d\n", iNum4);
		System.out.printf("%5d\n", iNum4);
		System.out.printf("%-5d\n", iNum4);
		
		System.out.printf("%f\n",10/4.0);
		System.out.printf("%.2f\n", 10/4.0);
		System.out.printf("%.0f\n", 10/4.0);
		
		boolean isTrue = false;
		char ch = '��';
		String str = "����Ŀ�";
		
		System.out.printf("%b / %c / %s\n", isTrue , ch , str);
		
		System.out.println("\\");
		System.out.println("a\tb\tc\td"); 		// tab
		System.out.println("��\n\n\n\n��"); 	// ����
		System.out.println("\"�ȳ�\""); 		// \"
		System.out.println("'"); 				// Ȭ ����ǥ
		System.out.println("\u0041"); 			// �����ڵ�
		
	
	}

}
