package edu.kh.oop.method.model.service;

import java.util.Scanner;

import edu.kh.oop.method.model.vo.Member;

public class MemberService {
	
	private Scanner sc = new Scanner(System.in); 
	
	public MemberService() {}
	
//	[����������] [�����] 		|    ��ȯ��		|  �޼ҵ�([�Ű�����])	
//	public		| static		|  �⺻�ڷ���	|
//	protect		| final			|    ������		|
//	(default)	| abstract		|	  void		|
//	private		| static final	|				|
	
	
	//void = ��ȯ���� ���ٴ� ��ȯ��
	//return = �޼ҵ� ���� �� ȣ��η� ���� ������ ��� ��
	
	private Member memberInfo = null;
	
	private Member loginMember = null;
	
	public void displayMenu() {
		
		int menuNum = 0 ;
		
		do {
			System.out.println("==== ȸ�� ���� ���� ���α׷� v1 ====");
			System.out.println("1. ȸ�� ����");
			System.out.println("2. �α���");
			System.out.println("3. ȸ�� ���� ��ȸ");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("0. ���α׷� ����");
			
			System.out.print("�޴� �Է� >>>> ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			case 1 : System.out.println( signUp() );
				break;
			case 2 : System.out.println( login() );
				break;
			case 3 : System.out.println( selectMember() );
				break;
			case 4 : int result = updateMember();
					if(result == -1) {
						System.out.println("�α��� �� �̿����ּ���.\n");
					}else if(result == 0) {
						System.out.println("\n��й�ȣ�� ��ġ���� �ʽ��ϴ�.\n");
					}else {
						System.out.println("\nȸ�� ������ �����߽��ϴ�.\n");
					}
				break;
			case 0 : System.out.println("���α׷��� �����մϴ�.\n");
				break;
			default :System.out.println("�߸� �Է� �ϼ̽��ϴ�. \n�ٽ� �Է� ���ּ���.\n");
			}
			
		} while(menuNum != 0);
	
	}
		   //[ȣ���� �޼ҵ�� ���� ������] 
	public String signUp() {
		
		System.out.println("\n***** ȸ�� ���� *****");
		System.out.print("ID : ");
		String memberId = sc.next();
		System.out.print("PASSWORD : ");
		String memberPw = sc.next();
		System.out.print("PASSWORD CHECK : ");
		String memberCheck = sc.next();
		System.out.print("NAME : ");
		String memberName = sc.next();
		System.out.print("AGE : ");
		int memberAge = sc.nextInt();
		sc.nextLine();
		
		System.out.println();
		
		if(memberPw.equals(memberCheck)) {
			memberInfo = new Member(memberId, memberPw, memberName, memberAge);
			return "ȸ�� ���� �Ϸ�\n";
			// ���� �޼ҵ� ���� �� ȣ�� �޼ҵ�� return
			// ���� ������ �̵� O;
		}else {
			return "��й�ȣ�� Ȯ�����ּ���\n";
		}
		
		
		
	}

	public String login() {
		
		System.out.println("\n***** �α��� *****\n");
		
		if(memberInfo == null) {
			return "ȸ�������� �������ּ���\n";
		}
		
		
		System.out.print("ID : ");
		String memberId = sc.next();
		System.out.print("PASSWORD : ");
		String memberPw = sc.next();
		System.out.println();
		
		if( memberId.equals(memberInfo.getMemberId() )
				&& memberPw.equals(memberInfo.getMemberPw() ) )
		{	
			loginMember = memberInfo;
			return loginMember.getMemberName()+"�� �ݰ����ϴ�.\n";
			
		} else {
			return "ID �Ǵ� PASSWORD�� ��ġ���� �ʽ��ϴ�\n";
		}
		
	}
	
	public String selectMember() {
		
		System.out.println("\n***** ȸ�� ���� ��ȸ *****\n");
		
		if(loginMember == null) {
			
			return "�α����� ���� �������ּ���\n";
		}
		
		String str =	 "ID : " +loginMember.getMemberId() +"\n"
						+ "�̸� : "+ loginMember.getMemberName() +"\n" 
						+"���� : "+ loginMember.getMemberAge() +"��\n";
		return str;
	}

	public int updateMember() {
		
		System.out.println("\n***** ȸ�� ���� ����*****\n");
		
		if(loginMember==null) {
			return -1;
		}
		
		System.out.print("������ �̸� �Է� : ");
		String updateName = sc.next();
		System.out.print("������ ���� �Է� : ");
		int updateAge = sc.nextInt();
		sc.nextLine();
		
		System.out.print("��� ��ȣ Ȯ�� : ");
		String checkPw = sc.next();
		
		
		if(checkPw.equals(loginMember.getMemberPw())) {
			loginMember.setMemberName(updateName);
			loginMember.setMemberAge(updateAge);
			return 1;
		}else {
			return 0;
		}
		
		
	}
	
}
