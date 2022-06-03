package edu.kh.oarr.model.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {
	
	private Scanner sc = new Scanner(System.in);
	
	private Member[] memberArr = new Member[5];
	
	private Member loginMember = null;
	//private Member memberInfo = null;
	
	
	
	public MemberService() {
		
		memberArr[0] = new Member("user01","pass01","ȫ�浿",30,"�λ�");
		memberArr[1] = new Member("user02","pass02","������",63,"����");
		memberArr[2] = new Member("user03","pass03","�����",59,"�ȵ�");
		
	}
	
	
	
	public void displayMenu() {
		
		int menuNum = 0 ;
		
		do {
			System.out.println("\n==== ȸ�� ���� ���� ���α׷� v2 ====\n");
			System.out.println("1. ȸ�� ����");
			System.out.println("2. �α���");
			System.out.println("3. ȸ�� ���� ��ȸ");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("5. ȸ�� �˻� (����)");
			System.out.println("0. ���α׷� ����\n");
			
			System.out.print("�޴� �Է� >>>> ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			case 1 : System.out.println(signUp());
				break;
			case 2 : System.out.println(login());
				break;
			case 3 : System.out.println(selectMember());
				break;
			case 4 : System.out.println(updateMember());
				break;
			case 5 : searchRegion();
				break;
			case 0 : System.out.println("\n���α׷��� �����մϴ�.\n");
				break;
			default :System.out.println("\n�߸� �Է� �ϼ̽��ϴ�. \n�ٽ� �Է� ���ּ���.\n");
			}
			
			
		} while(menuNum != 0);
	
	}
	
	public String signUp() {
		
		System.out.println("\n======== ȸ������ ========\n");
		
		int index = emptyIndex();
		
		System.out.println("���� ȸ�� �� : "+(index));
		
		if(index == -1) {
			return "ȸ�������� �Ұ����մϴ�.";
		}
		
		System.out.println("\n***** ȸ�� ���� *****");
		System.out.print("ID : ");
		String memberId = sc.next();
		System.out.print("PASSWORD : ");
		String memberPw = sc.next();
		System.out.print("PASSWORD CHECK : ");
		String pwCheck = sc.next();
		System.out.print("NAME : ");
		String memberName = sc.next();
		System.out.print("AGE : ");
		int memberAge = sc.nextInt();
		sc.nextLine();
		System.out.print("REGION : ");
		String region = sc.next();
		
		if(memberPw.equals(pwCheck)) {
			memberArr[index] = new Member(memberId,memberPw,memberName,memberAge,region);
			return "\nȸ�� ������ �Ϸ�Ǿ����ϴ�.";
		}else {
			return "\n��й�ȣ�� ��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�."
					+ "\nȸ�������� �ٽ� �õ� ���ּ���.";
		}
		
	}
	
	public int emptyIndex() {
		for(int i=0;i<memberArr.length;i++) {
			if(memberArr[i]==null) {
				return i;
			}
		}
		return -1;
	}
	
	public String login() {
		
		System.out.println("\n========= �α��� =========\n");
		
		System.out.print("���̵� �Է� : ");
		String memberId = sc.next();
		
		System.out.print("��й�ȣ �Է� : ");
		String memberPw = sc.next();

		for(int i=0;i<memberArr.length;i++) {
			if(memberArr[i]!=null) {
				if(memberArr[i].getMemberId().equals(memberId)
					&&memberArr[i].getMemberPw().equals(memberPw)) 
				{	
					loginMember = memberArr[i];
					break;
				}
			}
		}
		
		if(loginMember == null) {
			return "\nID �Ǵ� PASSWORD�� ��ġ���� �ʽ��ϴ�.";
		}else {
			return  "\n�α����� �Ϸ�Ǿ����ϴ�." + 
					"\n"+loginMember.getMemberName()+"�� �ݰ����ϴ�.";
		}
	}
	
	public String selectMember() {
		
		System.out.println("\n========== ȸ�� ���� ��ȸ ==========\n");
		
		if(loginMember == null) { 
			return "�α��� �� �̿� ���ּ���.";
		}

		String str = "�̸� : " + loginMember.getMemberName();

		str += "\n���̵� : " + loginMember.getMemberId();
		
		str += "\n���� : " + loginMember.getMemberAge() + "��";
		
		str += "\n���� : " + loginMember.getRegion();
		
		return str;
	}

	public String updateMember() {
		
		System.out.println("\n========== ȸ�� ���� ���� ==========\n");
		
		if(loginMember == null) {
			return "�α��� �� �̿����ּ���. " ;
		}
		
		System.out.print("PASSWORD : ");
		String checkPw = sc.next();
		System.out.println();
		
		if(checkPw.equals(loginMember.getMemberPw())) {
			
			System.out.print("���� �� �̸� : ");
			String changeName = sc.next();
			System.out.print("���� �� ���� : ");
			int changeAge = sc.nextInt();
			System.out.print("���� �� ���� : ");
			String changeRegion = sc.next();
			
			loginMember.setMemberName(changeName);
			loginMember.setMemberAge(changeAge);
			loginMember.setRegion(changeRegion);
			System.out.println();
			
			return "ȸ�� ������ ���� �Ǿ����ϴ�.";
			
		}else {
			System.out.println();
			return "PASSWORD�� ��ġ���� �ʽ��ϴ�. ";
		}
		
		
	}

	public void searchRegion() {
		
		System.out.println("\n======== ȸ�� �˻� (����) ========\n");
		
		System.out.print("�˻� ���� �Է� : ");
		String inputRegion = sc.next();
		System.out.println();
		System.out.println(inputRegion + "�� �����ϴ� ȸ������ \n");
		
		boolean a = false;
		
		for(int i=0;i<memberArr.length;i++) {
			if(memberArr[i] == null) {
				break;
			}
			if(memberArr[i].getRegion().equals(inputRegion)) {
				System.out.println("�̸� : " + memberArr[i].getMemberName());
				System.out.println("ID : " + memberArr[i].getMemberId()+"\n");
				a = true;
			}

		}
		if(!a) {
				System.out.println("�ش� ������ �����ϴ� ȸ���� \n�������� �ʽ��ϴ�.\n");

		}
		
	}

	
}
