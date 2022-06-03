package edu.kh.jdbc.member.view;

import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.member.model.service.MemberService;
import edu.kh.jdbc.member.model.vo.Member;

public class MemberView {

	private Scanner sc = new Scanner(System.in);
	private MemberService service = new MemberService();

	/**
	 * 회원가입 메소드
	 */
	public void signUp() {
		System.out.println("\n [ 회원 가입 ] \n");
		
		String memberId;
		String memberPw;
		String memberName;
		char memberGender;
		
		try {
			
			while(true) { // id
				System.out.print("아이디 : ");
				memberId = sc.next();
				int result = service.duplicateCheck(memberId);
				
				if(result == 0) {
					System.out.println("\n사용 가능한 아이디 입니다.\n"); 
					break;
				}else {
					System.out.println("\n이미 가입된 아이디 입니다.\n");
				}
			}

			while(true){ // pw
				System.out.print("비밀 번호 : ");
				memberPw = sc.next();
				System.out.print("비밀 번호 확인 : ");
				String checkPw = sc.next();
					
				if(!memberPw.equals(checkPw)) 
					System.out.println("비밀 번호가 일치하지 않습니다.");
				else break;
			}
				// name
			System.out.print("성명 : ");
			memberName = sc.next();
				
			while(true) { //gender
				System.out.print("성별(M/F) : ");
				memberGender = sc.next().toUpperCase().charAt(0);
				
				if(memberGender == 'M' 
				|| memberGender == 'F') break;
				else System.out.println("\n성별 표기가 옳바른 형식이 아닙니다.\n");
			}
				//데이터 전달
			Member signUpMember = new Member(memberId, memberPw, memberName, memberGender);
				//결과 확인
			int result = service.signUp(signUpMember);
			if(result > 0) System.out.println("\n회원 가입이 완료 되었습니다.");
			else 		   System.out.println("\n회원 가입을 다시 시도 해주세요.");
			
		}catch(Exception e) {
			System.err.println("\n회원가입 진행 중 오류 발생\n");
			e.printStackTrace();
		}

	}


	/**
	 * 로그인
	 * @return 
	 */
	public Member login() {
		System.out.println(" [ 로그인 ] \n");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀 번호 : ");
		String memberPw = sc.next();
	
		Member mem = new Member();
		mem.setMemberId(memberId);
		mem.setMemberPw(memberPw);
		
		Member loginMember = null;
		try {
			loginMember = service.login(mem);
			if(loginMember != null) {
				System.out.println("\n [ 로그인 완료 ]\n");
				System.out.println(loginMember.getMemberName()+ "님 환영합니다.\n");
			}else {
				System.out.println("\n [ 아이디 또는 비밀번호가 일치하지 않습니다. ]");
			}
		} catch (Exception e) {
			System.err.println("\n < 로그인 과정에서 오류 발생 > \n");
			e.printStackTrace();
		}
		return loginMember;
	}


	/**
	 * @param loginMember 
	 * 
	 */
	public void myInfo(Member loginMember) {
		System.out.println("[ 내 정보 조회 ]\n");
		
		System.out.println("회원 번호 : " + loginMember.getMemberNo());
		System.out.println("아이디 : " + loginMember.getMemberId());
		System.out.println("이름 : " + loginMember.getMemberName());
		if(loginMember.getMemberGender() == 'M')
		{
			System.out.println("성별 : 남성");
		}else {
			System.out.println("성별 : 여성");
		}
		System.out.println("가입일 : " + loginMember.getEnrollDate());
		System.out.println();
	}


	public void selectAll() {
		System.out.println("\n [ 가입된 회원 목록 조회 ]");
		
		try {
			List<Member> memberList = service.selectAll();
			
			if(memberList.isEmpty()) System.out.println("가입 인원 없어");
			else{
				for(Member e : memberList) {
					System.out.printf("아이디 : %9s  이름 : %7s  가입일 : %9s\n"
									,e.getMemberId(),e.getMemberName(),e.getEnrollDate());
				}														//date 형식이지만 , 
			}															//print구문의 참조형은 자동toString
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void updateMyInfo(Member loginMember) {
		System.out.println("\n [ 내 정보 수정 ] \n");
		try {
			System.out.print("변경할 이름 : ");
			String memberName = sc.next();
			System.out.print("변경할 성별 : ");
			char memberGender = sc.next().toUpperCase().charAt(0);
			Member updateMem = new Member();
			updateMem.setMemberName(memberName);
			updateMem.setMemberGender(memberGender);
			updateMem.setMemberNo(loginMember.getMemberNo());
			
			int result = service.updateMyinfo(updateMem);
			
			if(result > 0) {
				System.out.println("\n\n정보 수정이 완료되었습니다.\n");
				loginMember.setMemberName(memberName);
				loginMember.setMemberGender(memberGender);
			}
			else 		   System.out.println("\n정보 수정을 다시 시도해주세요.");
			
		}catch(Exception e){
			System.err.println("\n정보 수정 중 예외 발생\n");
			e.printStackTrace();
		}
		
	}


	public void updatePass(Member loginMember) {
		System.out.println("\n [ 비밀번호 수정 ]\n");
		try {
			System.out.print("현재 비밀번호 : ");
			String currentPw = sc.next();
			int check = service.passCheck(loginMember.getMemberNo(),currentPw);
			if(check == 1) {
				while(true) {
					System.out.print("새 비밀번호 : ");
					String newPw = sc.next();
					System.out.print("새 비밀번호 확인 : ");
					String newPwChk = sc.next();
					
					if(newPw.equals(newPwChk)) {
						Member updatePw = new Member();
						updatePw.setMemberPw(newPw);
						updatePw.setMemberNo(loginMember.getMemberNo());
						int result = service.updatePw(updatePw);
						if(result > 0 ) {
							System.out.println("\n비밀번호가 변경되었습니다.\n");
							break;
						}else System.out.println("실패");
					}
					else System.out.println("\n새 비밀번호가 일치하지 않습니다.");
				}
			}
			else System.out.println("\n현재 비밀번호가 일치하지 않습니다.\n");
		}catch(Exception e){
			System.out.println("\n비밀번호 변경 중 오류가 발생했습니다.\n");
			e.printStackTrace();
		}
		
	}

	public Member secessionY(Member loginMember) {
		Member YN = loginMember;
		System.out.println("\n [ 회원 탈퇴 ] \n");
		System.out.print("현재 비밀번호 입력 : ");
		String secePw = sc.next();
		try {
			int check = service.passCheck(loginMember.getMemberNo(),secePw);
			if(check > 0) {
				System.out.print("\n정말 탈퇴하시겠습니까? (Y/N) : ");
				char agree = sc.next().toUpperCase().charAt(0);
				if(agree == 'Y') {
					int result = service.secessionY(loginMember.getMemberNo());
					if(result > 0) {
						System.out.println("\n탈퇴가 완료되었습니다.\n");
						YN = null;
					}
					else		  System.out.println("탈퇴 실패");
				}else {
					System.out.println("\n회원 탈퇴 취소\n");
				}
			}else {
				System.out.println("\n현재 비밀번호가 일치하지 않습니다.\n");
			}
		}catch(Exception e) {
			System.out.println("\n탈퇴 중 오류\n");
			e.printStackTrace();
		}
	return YN;
	}
}
