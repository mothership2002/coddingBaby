package edu.kh.inheritance.model.vo;

public class Employee extends Person{


	private String company;
	
	public Employee() {
		super();
	}

	public Employee(String name, int age, String nationality, String company) {
		super(name,age,nationality);
		this.company = company;
	}


	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public void move() {
		//�޼ҵ� ��Ī ��ġ   
		//��ȯ���� ��ġ						*��Ģ
		//�Ű����� ��ġ
		//���������� ���ų� ū ������
		
		System.out.println("����̸� �ϱ� ���� ������ �پ�ٴѴ�.");
	}
	@Override
	public String toString() {
		return super.toString()
				+ company;
	}
	
	
	
}
