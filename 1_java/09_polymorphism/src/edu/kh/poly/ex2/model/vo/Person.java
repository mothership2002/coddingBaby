package edu.kh.poly.ex2.model.vo;

public class Person extends Animal {

	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("����� ������ �̿��Ͽ� �Դ´�. ");
	}

	@Override
	public void breath() {
		// TODO Auto-generated method stub
		System.out.println("�ڳ� ������ ȣ���Ѵ�. ");
	}
	
	
}
