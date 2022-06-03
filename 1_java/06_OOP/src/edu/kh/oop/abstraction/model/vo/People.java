package edu.kh.oop.abstraction.model.vo;

//value object : 값 저장용 객체를 만들기 위한 클래스를 모아둔 패키지

public class People {
	
	//class == 객체의 특성 (속성,기능)을 정의한 것
	//         객체설계도
	
	//캡슐화(encapsulation)
	//데이터와 기능을 하나로 묶어서 관리
	//데이터의 직접적인 접근 제한 원칙
	
	
	//속성 == data
	//(값을 저장하기 위한 변수 선언)
	//People => 국민이라면 갖고 있는 공통적 특성 
	//ex.(이름 성별 주민번호 주소 전화번호 나이)
	private String name;
	private char gender;
	private String pNo;
	private String address;
	private String phoneNo;
	private int age;
	
	//private 
	
	//기능 == method
	public void tax() {
		System.out.println("세금 납부");
	}
	
	public void vote() {
		System.out.println("투표권 행사");
	}
	
	//캡슐화에서 사용할 간접 접근 기능(getter,setter)
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
