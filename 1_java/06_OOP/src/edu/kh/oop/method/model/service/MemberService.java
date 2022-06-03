package edu.kh.oop.method.model.service;

import java.util.Scanner;

import edu.kh.oop.method.model.vo.Member;

public class MemberService {
	
	private Scanner sc = new Scanner(System.in); 
	
	public MemberService() {}
	
//	[접근제한자] [예약어] 		|    반환형		|  메소드([매개변수])	
//	public		| static		|  기본자료형	|
//	protect		| final			|    참조형		|
//	(default)	| abstract		|	  void		|
//	private		| static final	|				|
	
	
	//void = 반환값이 없다는 반환형
	//return = 메소드 실행 후 호출부로 돌아 가져갈 결과 값
	
	private Member memberInfo = null;
	
	private Member loginMember = null;
	
	public void displayMenu() {
		
		int menuNum = 0 ;
		
		do {
			System.out.println("==== 회원 정보 관리 프로그램 v1 ====");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 >>>> ");
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
						System.out.println("로그인 후 이용해주세요.\n");
					}else if(result == 0) {
						System.out.println("\n비밀번호가 일치하지 않습니다.\n");
					}else {
						System.out.println("\n회원 정보를 변경했습니다.\n");
					}
				break;
			case 0 : System.out.println("프로그램을 종료합니다.\n");
				break;
			default :System.out.println("잘못 입력 하셨습니다. \n다시 입력 해주세요.\n");
			}
			
		} while(menuNum != 0);
	
	}
		   //[호출한 메소드로 값을 가져감] 
	public String signUp() {
		
		System.out.println("\n***** 회원 가입 *****");
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
			return "회원 가입 완료\n";
			// 현재 메소드 종료 후 호출 메소드로 return
			// 값을 가지고 이동 O;
		}else {
			return "비밀번호를 확인해주세요\n";
		}
		
		
		
	}

	public String login() {
		
		System.out.println("\n***** 로그인 *****\n");
		
		if(memberInfo == null) {
			return "회원가입을 진행해주세요\n";
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
			return loginMember.getMemberName()+"님 반갑습니다.\n";
			
		} else {
			return "ID 또는 PASSWORD가 일치하지 않습니다\n";
		}
		
	}
	
	public String selectMember() {
		
		System.out.println("\n***** 회원 정보 조회 *****\n");
		
		if(loginMember == null) {
			
			return "로그인을 먼저 진행해주세요\n";
		}
		
		String str =	 "ID : " +loginMember.getMemberId() +"\n"
						+ "이름 : "+ loginMember.getMemberName() +"\n" 
						+"나이 : "+ loginMember.getMemberAge() +"세\n";
		return str;
	}

	public int updateMember() {
		
		System.out.println("\n***** 회원 정보 수정*****\n");
		
		if(loginMember==null) {
			return -1;
		}
		
		System.out.print("변경할 이름 입력 : ");
		String updateName = sc.next();
		System.out.print("변경할 나이 입력 : ");
		int updateAge = sc.nextInt();
		sc.nextLine();
		
		System.out.print("비밀 번호 확인 : ");
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
