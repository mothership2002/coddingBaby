package edu.kh.collection.model.vo;

public class Member {

	
	private String id;
	private String pw;
	
	private int age;
	
	public Member() {}

	public Member(String id, String pw, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", age=" + age + "]";
	}

	@Override
	public boolean equals(Object obj) {
		
		Member other = (Member)obj;
		
		return this.id.equals(other.id)&&this.pw.equals(other.pw)&&this.age==other.age;
	}

	@Override
	public int hashCode() {
		
		final int Prime = 31;
		
		int result = 1; //결과 저장변수
		
		result = result * Prime * age;
		
		result = result * Prime * (id == null ? 0 : id.hashCode());

		result = result * Prime * (pw == null ? 0 : pw.hashCode());

		return  result;
		
	}
	
}
