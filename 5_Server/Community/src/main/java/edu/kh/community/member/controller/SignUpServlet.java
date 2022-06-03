package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/signUp")
public class SignUpServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/signUp.jsp";
		req.getRequestDispatcher(path).forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberEmail = req.getParameter("memberEmail");
		String memberPW = req.getParameter("memberPW");
		String memberNickname = req.getParameter("memberNickname");
		String memberTel = req.getParameter("memberTel");
		String[] address = req.getParameterValues("memberAddress");
		
		String memberAddress = null;
		if(!address[0].equals("")) {
			memberAddress = String.join(",,", address);
		}

		Member member = new Member();
		member.setMemberEmail(memberEmail);
		member.setMemberPW(memberPW);
		member.setMemberNickname(memberNickname);
		member.setMemberTel(memberTel);
		member.setMemberAddress(memberAddress);
		
		try {
			MemberService service = new MemberService();
			
			int result = service.signUp(member);
			HttpSession session = req.getSession();
			if(result>0) session.setAttribute("message", "회원가입이 완료 되었습니다.");
			else		 session.setAttribute("message", "실패");
			
			resp.sendRedirect(req.getContextPath());
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
