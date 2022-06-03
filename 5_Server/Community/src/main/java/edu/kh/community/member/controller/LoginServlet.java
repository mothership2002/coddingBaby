package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberEmail = req.getParameter("inputEmail");
		String memberPw = req.getParameter("inputPW");
//		모든 post 메소드에 인코딩 변경 코드 작성 대체
//		filter - lombok 라이브러리 설치 
		Member member = new Member();
		member.setMemberEmail(memberEmail);
		member.setMemberPW(memberPw);
		
		try {
			MemberService service = new MemberService();
			Member loginMember = service.login(member);
			
			HttpSession session = req.getSession();
			
			if(loginMember!=null) {
				session.setAttribute("loginMember", loginMember);
				session.setMaxInactiveInterval(3600);
				
				Cookie saveId = new Cookie("memberEmail",memberEmail);
//											클라쪽 쿠키 이름 // 쿠키값
				if(req.getParameter("saveId")!=null) 
					 saveId.setMaxAge(2592000);
				else saveId.setMaxAge(0);
				
				saveId.setPath(req.getContextPath());
				resp.addCookie(saveId);
			} else {
				session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			}
			
			//	forward
			//-	servlet으로 응답 화면을 만들기가 불편하기 때문에
			//	jsp로 req,resp 객체를 위임
			//	요청에 대한 응답 화면을 대신 작성
			
			//	redirect
			//- servlet에서의 응답 화면을 만들지 않고
			//	해당하는 기능의 화면으로 넘김
			
			resp.sendRedirect(req.getContextPath());
//			패키지 최상위 주소 = index 
//			req.getRequestDispatcher("index.jsp").forward(req, resp);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
