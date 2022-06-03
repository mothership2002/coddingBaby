package edu.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String requestist = req.getParameter("requestist");
		
		String[] coffee= req.getParameterValues("coffee");
		
		if(coffee != null) {
			for(String e : coffee) {
				System.out.println(e);
			}
		}else {
			System.out.println("주문없음");
		}
		
		System.out.println(requestist);
		System.out.println("======================================");
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>"+requestist+"님의 주문 목록</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul>");
		if(coffee!=null) {
			for(String c : coffee) {
				out.println("<li>"+c+"</li>");
			}
		}else {
			out.println("주문이 없습니다.");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

}
