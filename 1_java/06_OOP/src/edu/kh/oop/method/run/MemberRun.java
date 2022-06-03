package edu.kh.oop.method.run;

import edu.kh.oop.method.model.service.MemberService;

public class MemberRun {

		public	  static   void   main(String[] args) {
//	[접근제한자] [예약어] 반환형  메소드([매개변수])	
//	main method
		
		MemberService service = new MemberService();
		//memberservice의 기본 생성자가 작성되어 있지 않지만 사용 가능
		//컴파일러가 실행될때
		//class 내부에 생성자가 없을 경우 자동으로 기본 생성자를 추가
		//			생성자 존재 시 자동생성 불가
		
		service.displayMenu();
		
		
				
		
		
		
		
		
		}





}
