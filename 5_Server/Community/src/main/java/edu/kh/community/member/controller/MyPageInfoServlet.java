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

@WebServlet("/member/myPage/info")
public class MyPageInfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/myPage-info.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberNickname = req.getParameter("memberNickname");
		String memberTel = req.getParameter("memberTel");
		String[] address = req.getParameterValues("memberAddress");
		String memberAddress = null;
		
		if(!address[0].equals("")) {
			memberAddress = String.join(",,", address);
		}
		
		HttpSession session = req.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		int memberNo = loginMember.getMemberNo();
		Member updateMember = new Member();
		updateMember.setMemberNo(memberNo);
		updateMember.setMemberNickname(memberNickname);
		updateMember.setMemberTel(memberTel);
		updateMember.setMemberAddress(memberAddress);
		try {
			MemberService service = new MemberService();
			int result = service.updateInfo(updateMember);	
			if(result >0) { 
				session.setAttribute("message", "수정이 완료되었습니다.");
				loginMember.setMemberNickname(memberNickname);
				loginMember.setMemberTel(memberTel);
				loginMember.setMemberAddress(memberAddress);
			} else {
				session.setAttribute("message", "수정이 비정상적으로 종료 되었습니다.\n"
										+ "다시 시도해 주세요.");
			}
			resp.sendRedirect("info");
//			req.getContextPath() + "/member/myPage/info
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
