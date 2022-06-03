package edu.kh.inheritance.model.service;

import java.util.Scanner;

import edu.kh.inheritance.model.vo.Employee;
import edu.kh.inheritance.model.vo.Person;
import edu.kh.inheritance.model.vo.Student;

public class InheritanceService {

	public void ex1() {
		//��� Ȯ�ο�
		
		Person p = new Person();
		
		p.setName("ȫ�浿");
		p.setAge(25);
		p.setNationality("���ѹα�");
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getNationality());
		
		System.out.println("------------------------------");
		
		Student std = new Student();
		
		std.setName("������");
		std.setAge(60);
		std.setNationality("���ѹα�");
		
		System.out.println(std.getGrade());
		System.out.println(std.getClassRoom());
		
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		
		System.out.println("-----------------------------");
		Employee emp = new Employee();
		
		emp.setCompany("kh����������");
		emp.setAge(33);	
		emp.setName("�鵿��");
		
		System.out.println(emp.getCompany());
		System.out.println(emp.getName());
		
		
		System.out.println("------------------------------");
		
		p.breath();
		std.breath();
		emp.breath();
		
	}
	public void ex2() {
		Student std = new Student("��ö��",17,"���ѹα�",1,3);
			
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		
		
		System.out.println(std.getGrade());
		System.out.println(std.getClassRoom());
		
		
	}
	public void ex3() {
		Employee emp = new Employee();
		
		emp.setName("�ӵ���");
		emp.setAge(28);
		emp.setNationality("���ѹα�");
		
		System.out.println(emp.getName());
		System.out.println(emp.getAge());
		System.out.println(emp.getNationality());
		
		emp.breath();
		emp.move();
		
		
	}
	public void ex4() {
		Person p = new Person("�����",58,"���ѹα�"); //object ��ӹ���
		
		System.out.println(p.toString());
	
		Student std = new Student("������",60,"���ѹα�",3,3);
		
		System.out.println(std.toString());
		
		Employee emp = new Employee("�ӵ���",28,"���ѹα�","���");
		
		System.out.println(emp.toString());
		
	}
	

}
