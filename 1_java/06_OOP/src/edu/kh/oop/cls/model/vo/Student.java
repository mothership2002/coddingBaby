package edu.kh.oop.cls.model.vo;

public class Student { 	//class �����
						//public = ���������� -> �ٸ� ��Ű�������� import����
						//public ���� ��� = ���� ��Ű�������� import ����
						//public []	class : [�����] �ڸ�
						//���������� ���Ǿ� class Ŭ������ {
	
	//	[]: ���� ���� 
	//	(): ������ ����
	
	//~=tilled -> still���� �����غ�
	
	// 1. field	: �ν��Ͻ��� �Ӽ��� �ۼ��ϴ� Ŭ���� ���� ����
	//private String name;
	//private intage;
	
	//��� ���� == field : �޼ҵ� �ۿ� �ۼ��� ����
	
	//�ν��Ͻ� ���� == �ʵ忡 �ۼ��Ǵ� �Ϲ� ����
	
	//Ŭ���� ���� == static ���� == �ʵ忡 ����ƽ���� �ۼ��� ����
	
	
	/*	 [����������] 	|	 [�����] 	 |		�ڷ��� 		|	������ [= �ʱⰪ];
	 *  public		+	|	   final	 |	  �⺻ �ڷ���	|											
	 *	protected	#	|	  static	 |		 �迭		|							
	 *	(default)	~	|  final static	 |	   Ŭ������ 	|								
	 *	private		-	|  static final  |	   (������)		|						
	 */
	
	/*	�ʵ��� ������������ �ǹ� : ���� ���� ������ ������ ����
	 *	   ���� 	|  �ش� Ŭ���� ����  |  ���� ��Ű�� ��	|  ��� Ŭ����	|	��ü
	 * 	 public		|		  O		  	 |		   O		|		O		|	  O
	 *   protected	|		  O		  	 |		   O		|		O  		|
	 *   (default)	|		  O		  	 |		   O		|				|
	 * 	 private	|		  O		  	 |					|				|
	 */
	
	/*	static = ���� 
	 * ������ ������ ���� �ۼ�
	 * 
	 */
	
	// 2. ������ (constructor)				
	//public Member() {}
	
	/* new �����ڸ� ���ؼ� ��ü�� ������ �� 
	 * ������ ��ü�� �ʵ� �� �ʱ�ȭ �� ������ ����� �����ϴ� ����
	 * 1)�������� �̸��� �ݵ�� Ŭ������� �����ؾ� ��
	 * 2)��ȯ���� �������� �ʴ´�
	 * 3)
	 * 
	 */
	
	/* ������ ����
	 * 1) �⺻ ������
	 * 2) �Ű����� ������
	 * 
	 */
	
	//�⺻ ������
	//[����������] Ŭ������(){
	public Student() {
		
		System.out.println("�⺻ �����ڿ� ���� Student ��ü ���� ");
		
	}
	

	
	
	

	
	
	// 3. method
	//public String getName() {
	//return name;
	//}
	//public void setName(String name) {
	//this.name= name;
	//}
	//public int getAge() {
	//returnage;
	//}
	//public void setAge(int age) {
	//this.age= age;
	
	
	
	
	
	
	
	
	
	
}
