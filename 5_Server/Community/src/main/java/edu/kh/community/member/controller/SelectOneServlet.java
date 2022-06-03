package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/selectOne")
public class SelectOneServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("memberEmail");
		try {
			MemberService service = new MemberService();
			Member member = service.selectOne(email);
//			1) original json
//			String str = "{\"memberNickname\":\""+member.getMemberNickname()+"\"}";
//			resp.getWriter().print(str);
			if(member != null) {
//			2)	json library
//				JSONObject obj = new JSONObject();
//				obj.put("memberEmail",member.getMemberEmail());
//				obj.put("memberNickname",member.getMemberNickname());
//				obj.put("memberTel", member.getMemberTel());
//				obj.put("memberAddress", member.getMemberAddress());
//				obj.put("enrollDate", member.getEnrollDate());
//				resp.getWriter().print(obj);
//			3) gson library
				new Gson().toJson(member,resp.getWriter());
				
			}else {
				resp.getWriter().print(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
