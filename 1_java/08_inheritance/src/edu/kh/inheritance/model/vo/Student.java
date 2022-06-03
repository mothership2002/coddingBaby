package edu.kh.inheritance.model.vo;

public class Student extends Person{
	
	//extends == 확장하다
	
	//필드와 메소드를 모두 갖고옴 (생성자는 제외)
	
	private int grade;
	private int classRoom;
	
	//상속만 중복 필드 제거가능
	
	public Student() {super();	}

	public Student
	(String name, int age, String nationality, int grade, int classRoom) {
	
		super(name, age, nationality);
		
		this.grade = grade;
		this.classRoom = classRoom;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	
	@Override
	public String toString() {
		return super.toString()	
				+grade+" / "+classRoom;
	}
	
	
}
