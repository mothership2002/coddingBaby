package edu.kh.inheritance.model.service;

import java.util.Scanner;

import edu.kh.inheritance.model.vo.Employee;
import edu.kh.inheritance.model.vo.Person;
import edu.kh.inheritance.model.vo.Student;

public class InheritanceService {

	public void ex1() {
		//상속 확인용
		
		Person p = new Person();
		
		p.setName("홍길동");
		p.setAge(25);
		p.setNationality("대한민국");
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getNationality());
		
		System.out.println("------------------------------");
		
		Student std = new Student();
		
		std.setName("윤석열");
		std.setAge(60);
		std.setNationality("대한민국");
		
		System.out.println(std.getGrade());
		System.out.println(std.getClassRoom());
		
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		
		System.out.println("-----------------------------");
		Employee emp = new Employee();
		
		emp.setCompany("kh정보교육원");
		emp.setAge(33);	
		emp.setName("백동현");
		
		System.out.println(emp.getCompany());
		System.out.println(emp.getName());
		
		
		System.out.println("------------------------------");
		
		p.breath();
		std.breath();
		emp.breath();
		
	}
	public void ex2() {
		Student std = new Student("김철수",17,"대한민국",1,3);
			
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		
		
		System.out.println(std.getGrade());
		System.out.println(std.getClassRoom());
		
		
	}
	public void ex3() {
		Employee emp = new Employee();
		
		emp.setName("임동현");
		emp.setAge(28);
		emp.setNationality("대한민국");
		
		System.out.println(emp.getName());
		System.out.println(emp.getAge());
		System.out.println(emp.getNationality());
		
		emp.breath();
		emp.move();
		
		
	}
	public void ex4() {
		Person p = new Person("이재명",58,"대한민국"); //object 상속받음
		
		System.out.println(p.toString());
	
		Student std = new Student("윤석열",60,"대한민국",3,3);
		
		System.out.println(std.toString());
		
		Employee emp = new Employee("임동현",28,"대한민국","백수");
		
		System.out.println(emp.toString());
		
	}
	

}
