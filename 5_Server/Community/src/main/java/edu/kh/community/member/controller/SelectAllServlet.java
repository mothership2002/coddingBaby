package edu.kh.community.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/selectAll")
public class SelectAllServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberService service = new MemberService();
			List<Member> memberList = service.selectAll();
			if(memberList!=null) {
				new Gson().toJson(memberList,resp.getWriter());
			}else {
				resp.getWriter().print(memberList);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
