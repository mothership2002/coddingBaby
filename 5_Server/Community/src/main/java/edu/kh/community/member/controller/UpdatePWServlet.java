package edu.kh.community.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/myPage/updatePW")
public class UpdatePWServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/updatePW.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String currentPW = req.getParameter("password");
		String updatePW = req.getParameter("updatePW");
		HttpSession session = req.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		int memberNo = loginMember.getMemberNo();
		HashMap<String, String> sendPw = new HashMap<String, String>();
		sendPw.put("currentPW", currentPW);
		sendPw.put("updatePW", updatePW);
		try {
			MemberService service = new MemberService();
			//map 사용
			int result = service.passwordCheck(memberNo,sendPw);
			String path = null;
			if(result>0) {
				session.setAttribute("message", "비밀번호가 변경 되었습니다.");
				path = "info";
			} else {
				session.setAttribute("message", "비밀번호가 일치하지 않습니다.");
				path = "updatePW";
			}
			resp.sendRedirect(path);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}