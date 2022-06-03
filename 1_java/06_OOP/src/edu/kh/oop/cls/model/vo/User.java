package edu.kh.oop.cls.model.vo;

public class User {
	
	//속성 == field
	
	//아이디 비밀번호 이름 나이 성별
	
	private String userId;
	private String userPW;
	private String userName;
	private int userAge;
	private char userGender;
	
	//constructor : new 연산자로 인한 객체 생성 시
	//생성된 객체의 필드 값 초기화 및 기능 수행
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPW(){
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	public char getUserGender() {
		return userGender;
	}
	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}
	
	public User() {
		
		System.out.println("기본 생성자로 User 객체 생성");
		userId = "user01";
		userPW = "pass01";
		userName = "홍길동";
		userAge = 20;
		userGender = 'M';
		
	}
	
	//매개변수 생성자 
	//사용되는 것 : overloading, this, 매개변수
	
	//매개변수 : 생성자나 메소드를 호출 시 ()안에 작성되어 
	//			 전달되는 값을 저장하는 변수 ;
	
	public User(String userId,String userPW) {
		
		System.out.println("매개변수 생성자로 인한 User 객체 생성");
		System.out.println(userId + " / "+ userPW);
		//전달 받은 값을 필드에 초기화 (this.참조 변수)
		
		//this. 
		// - 객체 생성 시 자동으로 만들어지는 참조값
		// 객체가 자기 자신을 참조할 수 있도록 하는 변수
		// 모든 객체가 가지고 있음
		
		//-필드명과 매개변수가 같을 경우 구분하기 위해 사용
		
		this.userId = userId;
		this.userPW = userPW;
		
	}
	
	//필드를 전부 초기화 하는 매개변수 생성자
	
	public User
	(String userId, String userPW, String userName, int userAge, char userGender) 
	{	
		
		
		this(userId,userPW); //<this() 같은 클래스의 다른 생성자 호출명령어
							 // 반드시 생성자 내의 첫번째 줄에 작성해야 함
//		this.userId = userId;
//		this.userPW = userPW;
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
		
		
	}
	//overloading - 동일한 명칭의 여러 메소드를 작성 
	
	public User(String userId) { //매개변수의 개수가 같은 생성자 없음
								 //오버로딩 성립;
	}
	
	public User(int userAge) {	//매개변수의 개수는 같지만 타입이 다름
								//성립
	}
	
	public User(String userId, int userAge) { //매개변수 개수가 다르므로
											  //성립
	}
	public User(int userAge, String userID) {//순서가 다르므로
											// 성립
	}
	
//	public User(int userAge, String userName) {
//		//매개변수 개수 타입 순서 같기때문에 성립불가 - 변수명은 상관없음
//	}
	
	
}
