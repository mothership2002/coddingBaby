package edu.kh.oop.abstraction.model.vo;

//value object : �� ����� ��ü�� ����� ���� Ŭ������ ��Ƶ� ��Ű��

public class People {
	
	//class == ��ü�� Ư�� (�Ӽ�,���)�� ������ ��
	//         ��ü���赵
	
	//ĸ��ȭ(encapsulation)
	//�����Ϳ� ����� �ϳ��� ��� ����
	//�������� �������� ���� ���� ��Ģ
	
	
	//�Ӽ� == data
	//(���� �����ϱ� ���� ���� ����)
	//People => �����̶�� ���� �ִ� ������ Ư�� 
	//ex.(�̸� ���� �ֹι�ȣ �ּ� ��ȭ��ȣ ����)
	private String name;
	private char gender;
	private String pNo;
	private String address;
	private String phoneNo;
	private int age;
	
	//private 
	
	//��� == method
	public void tax() {
		System.out.println("���� ����");
	}
	
	public void vote() {
		System.out.println("��ǥ�� ���");
	}
	
	//ĸ��ȭ���� ����� ���� ���� ���(getter,setter)
	//crtl - shift - s
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
