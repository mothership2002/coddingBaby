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
		//메소드 명칭 일치   
		//반환형도 일치						*규칙
		//매개변수 일치
		//접근제한자 같거나 큰 범위로
		
		System.out.println("밥벌이를 하기 위해 열심히 뛰어다닌다.");
	}
	@Override
	public String toString() {
		return super.toString()
				+ company;
	}
	
	
	
}
