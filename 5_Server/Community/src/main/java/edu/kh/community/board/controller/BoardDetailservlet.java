package edu.kh.community.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.community.board.model.service.BoardService;
import edu.kh.community.board.model.service.ReplyService;
import edu.kh.community.board.model.vo.BoardDetail;
import edu.kh.community.board.model.vo.Reply;

@WebServlet("/board/detail")
public class BoardDetailservlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int boardNo = Integer.parseInt(req.getParameter("no"));
			BoardService service = new BoardService();
			BoardDetail detail = service.selectBoardDeatil(boardNo);
			if(detail != null) {
				List<Reply> rList = new ReplyService().selectReplyList(boardNo);
				req.setAttribute("rList", rList);
			}
			req.setAttribute("detail", detail);
			String path = "/WEB-INF/views/board/boardDetail.jsp";
			RequestDispatcher dis = req.getRequestDispatcher(path);
			dis.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
