package edu.kh.test.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.test.user.model.service.UserService;
import edu.kh.test.user.model.vo.User;

@WebServlet("/selectUser")
public class SelectUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userNo =  Integer.parseInt(req.getParameter("userNo"));
		try {
			User user = new UserService().searchUser(userNo);
			if(user != null) {
				int no = user.getUserNo();
				String id = user.getUserID();
				String name = user.getUserName();
				int age = user.getUserAge();
				req.setAttribute("no", no);
				req.setAttribute("id", id);
				req.setAttribute("name", name);
				req.setAttribute("age", age);
				req.getRequestDispatcher("/WEB-INF/views/searchSuccess.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/WEB-INF/views/searchFail.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
