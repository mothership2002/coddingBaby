package edu.kh.oop.cls.model.vo;

public class Student { 	//class 선언부
						//public = 접근제어자 -> 다른 패키지에서도 import가능
						//public 없는 경우 = 같은 패키지에서만 import 가능
						//public []	class : [예약어] 자리
						//접근제한자 예악어 class 클래스명 {
	
	//	[]: 생략 가능 
	//	(): 무조건 생략
	
	//~=tilled -> still에서 생각해봄
	
	// 1. field	: 인스턴스의 속성을 작성하는 클래스 내부 영역
	//private String name;
	//private intage;
	
	//멤버 변수 == field : 메소드 밖에 작성된 변수
	
	//인스턴스 변수 == 필드에 작성되는 일반 변수
	
	//클래스 변수 == static 변수 == 필드에 스태틱예약어가 작성된 변수
	
	
	/*	 [접근제한자] 	|	 [예약어] 	 |		자료형 		|	변수명 [= 초기값];
	 *  public		+	|	   final	 |	  기본 자료형	|											
	 *	protected	#	|	  static	 |		 배열		|							
	 *	(default)	~	|  final static	 |	   클래스명 	|								
	 *	private		-	|  static final  |	   (참조형)		|						
	 */
	
	/*	필드의 접근제한자의 의미 : 직접 접근 가능한 범위를 지정
	 *	   구분 	|  해당 클래스 내부  |  같은 패키지 내	|  상속 클래스	|	전체
	 * 	 public		|		  O		  	 |		   O		|		O		|	  O
	 *   protected	|		  O		  	 |		   O		|		O  		|
	 *   (default)	|		  O		  	 |		   O		|				|
	 * 	 private	|		  O		  	 |					|				|
	 */
	
	/*	static = 공전 
	 * 공유의 목적을 갖고 작성
	 * 
	 */
	
	// 2. 생성자 (constructor)				
	//public Member() {}
	
	/* new 연산자를 통해서 객체를 생성할 때 
	 * 생성된 객체의 필드 값 초기화 및 지정된 기능을 수행하는 영역
	 * 1)생성자의 이름은 반드시 클래스명과 동일해야 함
	 * 2)반환형이 존재하지 않는다
	 * 3)
	 * 
	 */
	
	/* 생성자 종류
	 * 1) 기본 생성자
	 * 2) 매개변수 생성자
	 * 
	 */
	
	//기본 생성자
	//[접근제한자] 클래스명(){
	public Student() {
		
		System.out.println("기본 생성자에 의해 Student 객체 생성 ");
		
	}
	

	
	
	

	
	
	// 3. method
	//public String getName() {
	//return name;
	//}
	//public void setName(String name) {
	//this.name= name;
	//}
	//public int getAge() {
	//returnage;
	//}
	//public void setAge(int age) {
	//this.age= age;
	
	
	
	
	
	
	
	
	
	
}
