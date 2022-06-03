package edu.kh.SemiProject.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.SemiProject.member.model.service.UserService;
import edu.kh.SemiProject.member.model.vo.User;


@WebServlet("/user/*")
public class loginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
	    String contextPath = req.getContextPath();
	    String command = uri.substring((contextPath + "/user/").length());
	    try {
	    	//로그인 요청
	    	if(command.equals("login")) {
	    		UserService service = new UserService();
		    	String id = req.getParameter("ID");
		    	String pw = req.getParameter("PW");
		    	User user = new User();
		    	user.setUserID(id);
		    	user.setUserPW(pw);
		    	
		    	HttpSession session = req.getSession();
		    	
		    	User loginSession = service.login(user);
		    	if(loginSession !=null) {
		    		session.setAttribute("loginMember", loginSession);
		    		session.setMaxInactiveInterval(3600);
		    	}else {
		    		session.setAttribute("message", "아이디 또는 비밀번호를 확인해주세요");
		    	}
		    	resp.sendRedirect(req.getContextPath());
	    	}
	    	//회원가입
	    	//계정찾기
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}