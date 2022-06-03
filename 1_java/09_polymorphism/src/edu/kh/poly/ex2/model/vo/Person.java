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
		System.out.println("사람은 도구를 이용하여 먹는다. ");
	}

	@Override
	public void breath() {
		// TODO Auto-generated method stub
		System.out.println("코나 입으로 호흡한다. ");
	}
	
	
}
