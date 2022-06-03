package edu.kh.inheritance.model.vo;

public class Person extends Object{

	private String name;	
	private int age;
	private String nationality;
	
	public Person() {}
	
	public Person(String name,int age,String nationality) {
		this.name = name;
		this.age = age;
		this.nationality = nationality;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public void breath() {
		System.out.println( getName() + "은 호흡한다.");
	}
	
	public void move() {
		System.out.println( getName()+ "은 움직인다.");
	}
	@Override
	public String toString() {
		return name +" / "+age+" / "+nationality+" / ";
	}
	
	
	
}
