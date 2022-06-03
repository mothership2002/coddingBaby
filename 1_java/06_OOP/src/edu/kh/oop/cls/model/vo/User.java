package edu.kh.oop.cls.model.vo;

public class User {
	
	//�Ӽ� == field
	
	//���̵� ��й�ȣ �̸� ���� ����
	
	private String userId;
	private String userPW;
	private String userName;
	private int userAge;
	private char userGender;
	
	//constructor : new �����ڷ� ���� ��ü ���� ��
	//������ ��ü�� �ʵ� �� �ʱ�ȭ �� ��� ����
	
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
		
		System.out.println("�⺻ �����ڷ� User ��ü ����");
		userId = "user01";
		userPW = "pass01";
		userName = "ȫ�浿";
		userAge = 20;
		userGender = 'M';
		
	}
	
	//�Ű����� ������ 
	//���Ǵ� �� : overloading, this, �Ű�����
	
	//�Ű����� : �����ڳ� �޼ҵ带 ȣ�� �� ()�ȿ� �ۼ��Ǿ� 
	//			 ���޵Ǵ� ���� �����ϴ� ���� ;
	
	public User(String userId,String userPW) {
		
		System.out.println("�Ű����� �����ڷ� ���� User ��ü ����");
		System.out.println(userId + " / "+ userPW);
		//���� ���� ���� �ʵ忡 �ʱ�ȭ (this.���� ����)
		
		//this. 
		// - ��ü ���� �� �ڵ����� ��������� ������
		// ��ü�� �ڱ� �ڽ��� ������ �� �ֵ��� �ϴ� ����
		// ��� ��ü�� ������ ����
		
		//-�ʵ��� �Ű������� ���� ��� �����ϱ� ���� ���
		
		this.userId = userId;
		this.userPW = userPW;
		
	}
	
	//�ʵ带 ���� �ʱ�ȭ �ϴ� �Ű����� ������
	
	public User
	(String userId, String userPW, String userName, int userAge, char userGender) 
	{	
		
		
		this(userId,userPW); //<this() ���� Ŭ������ �ٸ� ������ ȣ���ɾ�
							 // �ݵ�� ������ ���� ù��° �ٿ� �ۼ��ؾ� ��
//		this.userId = userId;
//		this.userPW = userPW;
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
		
		
	}
	//overloading - ������ ��Ī�� ���� �޼ҵ带 �ۼ� 
	
	public User(String userId) { //�Ű������� ������ ���� ������ ����
								 //�����ε� ����;
	}
	
	public User(int userAge) {	//�Ű������� ������ ������ Ÿ���� �ٸ�
								//����
	}
	
	public User(String userId, int userAge) { //�Ű����� ������ �ٸ��Ƿ�
											  //����
	}
	public User(int userAge, String userID) {//������ �ٸ��Ƿ�
											// ����
	}
	
//	public User(int userAge, String userName) {
//		//�Ű����� ���� Ÿ�� ���� ���⶧���� �����Ұ� - �������� �������
//	}
	
	
}
