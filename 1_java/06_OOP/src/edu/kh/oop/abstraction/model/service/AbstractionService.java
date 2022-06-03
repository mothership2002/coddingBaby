package edu.kh.oop.abstraction.model.service;

import edu.kh.oop.abstraction.model.vo.People;

//service : 특정 기능(비즈니스 로직)을 제공하는 클래스
// 해당 클래스가 객체가 되면 아래 예제 기능을 수행 할 수 있다.

public class AbstractionService {
	
	public void ex1() {
		
		//국민 객체 만들기
		
		People p1 = new People();
		//People p1 : People 객체의 주소를 저장하요 참조하는 참조형 변수
		//new People - heap영역에 새로운 People 객체를 생성
		
		// 클래스 이름이 자료형으로 사용
		// 사용자 정의 자료형
		
		People p2 = new People();
		//추상화 적용 (대상 식별 불가)
		//데이터를 추가할 경우 대상 식별 가능
		
		p1.setName("홍길동");
		p1.setAge(25);
		p1.setGender('남');
		p1.setPhoneNo("01012341234");
		p1.setpNo("980101-1010101");
		p1.setAddress("서울특별시 중구 남대문로 120 대일빌딩 2층 A강의장");
		
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getGender());
		System.out.println(p1.getPhoneNo());
		System.out.println(p1.getpNo());
		System.out.println(p1.getAddress());
		
		p1.tax();
		p1.vote();
		
		System.out.println("==================================================");
		
		p2.setName("남길동");
		p2.setAge(33);
		p2.setGender('여');
		p2.setPhoneNo("01010101010");
		p2.setpNo("911212-2015426");
		p2.setAddress("서울특별시 중구 남대문로 4444 무슨빌딩 104호");
		
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		System.out.println(p2.getGender());
		System.out.println(p2.getPhoneNo());
		System.out.println(p2.getpNo());
		System.out.println(p2.getAddress());

		p2.tax();
		p2.vote();

		
		
	}

}
