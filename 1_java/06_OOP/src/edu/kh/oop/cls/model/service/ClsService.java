package edu.kh.oop.cls.model.service;

import edu.kh.oop.cls.model.vo.Student;
import edu.kh.oop.cls.model.vo.User;

public class ClsService {
	
	public void ex1() {
		
		//class 접근제한자 확인하기
		Student std = new Student();
		//패키지가 다르지만, public선언 이유로 import 가능
		
		//TestVo tv = new Testvo(); 선언 불가
		
	}
	
	public void ex3() {
		
		Student s1 = new Student();
		User u1 = new User();
		System.out.println(u1.getUserId());
		System.out.println(u1.getUserPW());
		System.out.println(u1.getUserName());
		System.out.println(u1.getUserAge());
		System.out.println(u1.getUserGender());
		
		System.out.println("========================================");
		
		User u2 = new User();
		System.out.println(u2.getUserId());
		System.out.println(u2.getUserPW());
		System.out.println(u2.getUserName());
		System.out.println(u2.getUserAge());
		System.out.println(u2.getUserGender());
		
		System.out.println("========================================");
		
		//setter 도입
		u2.setUserId("asdf1234");
		u2.setUserPW("1q2w3e4r");
		u2.setUserName("김영희");
		u2.setUserAge(19);
		u2.setUserGender('F');
		
		System.out.println(u2.getUserId());
		System.out.println(u2.getUserPW());
		System.out.println(u2.getUserName());
		System.out.println(u2.getUserAge());
		System.out.println(u2.getUserGender());
		
		//매개변수 생성자를 이용
		User u3 = new User("test1","pass1234");
		
		System.out.println(u3.getUserId());
		System.out.println(u3.getUserPW());
		
		
		
		
		
	}
	
	public void ex4() {
		
		User u1 = new User();
		
		User u2 = new User("user02","pass02");
		
		User u3 = new User("user03","pass03","남도일",17,'M');
		
		User u4 = new User("user04","pass04","계보린",25,'F');

		User u5 = new User("user05","pass05","이십팔",28,'M');
		
		System.out.printf("u1 : %s / %s / %s / %d / %c \n",u1.getUserId(),u1.getUserPW(),u1.getUserName(),u1.getUserAge(),u1.getUserGender());
		System.out.printf("u2 : %s / %s / %s / %d / %c \n",u2.getUserId(),u2.getUserPW(),u2.getUserName(),u2.getUserAge(),u2.getUserGender());
		System.out.printf("u3 : %s / %s / %s / %d / %c \n",u3.getUserId(),u3.getUserPW(),u3.getUserName(),u3.getUserAge(),u3.getUserGender());
		System.out.printf("u4 : %s / %s / %s / %d / %c \n",u4.getUserId(),u4.getUserPW(),u4.getUserName(),u4.getUserAge(),u4.getUserGender());
		System.out.printf("u5 : %s / %s / %s / %d / %c \n",u5.getUserId(),u5.getUserPW(),u5.getUserName(),u5.getUserAge(),u5.getUserGender());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
