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

@WebServlet("/member/myPage/secession")
public class SecessionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/secession.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String secessionAgree = req.getParameter("memberPw");
		HttpSession session = req.getSession(); 
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		int memberNo = loginMember.getMemberNo();
		try {
			MemberService service = new MemberService();
			int result = service.secessionAgree(memberNo,secessionAgree);
			String path = null;
			if(result>0) {
				session.setAttribute("message", "탈퇴가 완료 되었습니다.");
				//쿠키 지우기 
				// - 쿠키 생성 - 수명 0 초 - 쿠키 위치 설정
				Cookie saveId = new Cookie("memberEmail","");
				saveId.setMaxAge(0);
				saveId.setPath(req.getContextPath());
				resp.addCookie(saveId);
				path = "../logout";
			} else {
				session.setAttribute("message", "비밀번호가 올바르지 않습니다.");
				path = "secession";
			}
			resp.sendRedirect(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
