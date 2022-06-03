package edu.kh.oop.abstraction.model.service;

import edu.kh.oop.abstraction.model.vo.People;

//service : Ư�� ���(����Ͻ� ����)�� �����ϴ� Ŭ����
// �ش� Ŭ������ ��ü�� �Ǹ� �Ʒ� ���� ����� ���� �� �� �ִ�.

public class AbstractionService {
	
	public void ex1() {
		
		//���� ��ü �����
		
		People p1 = new People();
		//People p1 : People ��ü�� �ּҸ� �����Ͽ� �����ϴ� ������ ����
		//new People - heap������ ���ο� People ��ü�� ����
		
		// Ŭ���� �̸��� �ڷ������� ���
		// ����� ���� �ڷ���
		
		People p2 = new People();
		//�߻�ȭ ���� (��� �ĺ� �Ұ�)
		//�����͸� �߰��� ��� ��� �ĺ� ����
		
		p1.setName("ȫ�浿");
		p1.setAge(25);
		p1.setGender('��');
		p1.setPhoneNo("01012341234");
		p1.setpNo("980101-1010101");
		p1.setAddress("����Ư���� �߱� ���빮�� 120 ���Ϻ��� 2�� A������");
		
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getGender());
		System.out.println(p1.getPhoneNo());
		System.out.println(p1.getpNo());
		System.out.println(p1.getAddress());
		
		p1.tax();
		p1.vote();
		
		System.out.println("==================================================");
		
		p2.setName("���浿");
		p2.setAge(33);
		p2.setGender('��');
		p2.setPhoneNo("01010101010");
		p2.setpNo("911212-2015426");
		p2.setAddress("����Ư���� �߱� ���빮�� 4444 �������� 104ȣ");
		
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		System.out.println(p2.getGender());
		System.out.println(p2.getPhoneNo());
		System.out.println(p2.getpNo());
		System.out.println(p2.getAddress());

		p2.tax();
		p2.vote();

		
		
	}

}
