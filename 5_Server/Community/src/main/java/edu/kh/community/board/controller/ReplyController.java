package edu.kh.community.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.community.board.model.service.ReplyService;
import edu.kh.community.board.model.vo.Reply;

//selectReplyList
//insert
//update
//delete
@WebServlet("/reply/*")
public class ReplyController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
	    String contextPath = req.getContextPath();
	    String command = uri.substring((contextPath + "/reply/").length());
	    
	    ReplyService service = new ReplyService();
	    
	    try {
			if(command.equals("selectReplyList")) {
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));
				List<Reply> rList = service.selectReplyList(boardNo);
				new Gson().toJson(rList,resp.getWriter());
			}
			if(command.equals("replyInsert")) {
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));
				int memberNo = Integer.parseInt(req.getParameter("memberNo"));
				String replyContent = req.getParameter("replyContent");
				Reply reply = new Reply();
				reply.setBoardNo(boardNo);
				reply.setReplyContent(replyContent);
				reply.setMemberNo(memberNo);
				
				int result = service.replyInsert(reply);
				resp.getWriter().print(result);
			}
			if(command.equals("replyDelete")) {
				int replyNo = Integer.parseInt(req.getParameter("replyNo"));
				int result = service.replyDelete(replyNo);
				resp.getWriter().print(result);
			}
			if(command.equals("replyUpdate")) {
				int replyNo = Integer.parseInt(req.getParameter("replyNo"));
				String replyContent = req.getParameter("replyContent");
				int result = service.replyUpdate(replyNo,replyContent);
				resp.getWriter().print(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(500);
			resp.getWriter().print(e.getMessage());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
