package edu.kh.inheritance.model.vo;

public class Student extends Person{
	
	//extends == Ȯ���ϴ�
	
	//�ʵ�� �޼ҵ带 ��� ����� (�����ڴ� ����)
	
	private int grade;
	private int classRoom;
	
	//��Ӹ� �ߺ� �ʵ� ���Ű���
	
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
