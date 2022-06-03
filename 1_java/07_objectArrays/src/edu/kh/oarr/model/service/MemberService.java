package edu.kh.oarr.model.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {
	
	private Scanner sc = new Scanner(System.in);
	
	private Member[] memberArr = new Member[5];
	
	private Member loginMember = null;
	//private Member memberInfo = null;
	
	
	
	public MemberService() {
		
		memberArr[0] = new Member("user01","pass01","홍길동",30,"부산");
		memberArr[1] = new Member("user02","pass02","윤석열",63,"서울");
		memberArr[2] = new Member("user03","pass03","이재명",59,"안동");
		
	}
	
	
	
	public void displayMenu() {
		
		int menuNum = 0 ;
		
		do {
			System.out.println("\n==== 회원 정보 관리 프로그램 v2 ====\n");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 검색 (지역)");
			System.out.println("0. 프로그램 종료\n");
			
			System.out.print("메뉴 입력 >>>> ");
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
			case 0 : System.out.println("\n프로그램을 종료합니다.\n");
				break;
			default :System.out.println("\n잘못 입력 하셨습니다. \n다시 입력 해주세요.\n");
			}
			
			
		} while(menuNum != 0);
	
	}
	
	public String signUp() {
		
		System.out.println("\n======== 회원가입 ========\n");
		
		int index = emptyIndex();
		
		System.out.println("현재 회원 수 : "+(index));
		
		if(index == -1) {
			return "회원가입이 불가능합니다.";
		}
		
		System.out.println("\n***** 회원 가입 *****");
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
			return "\n회원 가입이 완료되었습니다.";
		}else {
			return "\n비밀번호와 비밀번호 확인이 일치하지 않습니다."
					+ "\n회원가입을 다시 시도 해주세요.";
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
		
		System.out.println("\n========= 로그인 =========\n");
		
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 입력 : ");
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
			return "\nID 또는 PASSWORD가 일치하지 않습니다.";
		}else {
			return  "\n로그인이 완료되었습니다." + 
					"\n"+loginMember.getMemberName()+"님 반갑습니다.";
		}
	}
	
	public String selectMember() {
		
		System.out.println("\n========== 회원 정보 조회 ==========\n");
		
		if(loginMember == null) { 
			return "로그인 후 이용 해주세요.";
		}

		String str = "이름 : " + loginMember.getMemberName();

		str += "\n아이디 : " + loginMember.getMemberId();
		
		str += "\n나이 : " + loginMember.getMemberAge() + "세";
		
		str += "\n지역 : " + loginMember.getRegion();
		
		return str;
	}

	public String updateMember() {
		
		System.out.println("\n========== 회원 정보 수정 ==========\n");
		
		if(loginMember == null) {
			return "로그인 후 이용해주세요. " ;
		}
		
		System.out.print("PASSWORD : ");
		String checkPw = sc.next();
		System.out.println();
		
		if(checkPw.equals(loginMember.getMemberPw())) {
			
			System.out.print("변경 할 이름 : ");
			String changeName = sc.next();
			System.out.print("변경 할 나이 : ");
			int changeAge = sc.nextInt();
			System.out.print("변경 할 지역 : ");
			String changeRegion = sc.next();
			
			loginMember.setMemberName(changeName);
			loginMember.setMemberAge(changeAge);
			loginMember.setRegion(changeRegion);
			System.out.println();
			
			return "회원 정보가 수정 되었습니다.";
			
		}else {
			System.out.println();
			return "PASSWORD가 일치하지 않습니다. ";
		}
		
		
	}

	public void searchRegion() {
		
		System.out.println("\n======== 회원 검색 (지역) ========\n");
		
		System.out.print("검색 지역 입력 : ");
		String inputRegion = sc.next();
		System.out.println();
		System.out.println(inputRegion + "에 거주하는 회원정보 \n");
		
		boolean a = false;
		
		for(int i=0;i<memberArr.length;i++) {
			if(memberArr[i] == null) {
				break;
			}
			if(memberArr[i].getRegion().equals(inputRegion)) {
				System.out.println("이름 : " + memberArr[i].getMemberName());
				System.out.println("ID : " + memberArr[i].getMemberId()+"\n");
				a = true;
			}

		}
		if(!a) {
				System.out.println("해당 지역에 거주하는 회원은 \n존재하지 않습니다.\n");

		}
		
	}

	
}
