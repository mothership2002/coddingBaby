package edu.kh.community.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "loginFilter",
		   urlPatterns = {"/board/write","/board/delete",
				   "/reply/insert","/reply/update","/reply/delete",
				   "/member/myPage/*"})
public class LoginFilter extends HttpFilter implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("로그인 필터 생성");
	}
       
	public void destroy() {
		System.out.println("로그인 필터 제거");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		if(session.getAttribute("loginMember") != null) {
			chain.doFilter(request, response);
		} else {
			session.setAttribute("message", "비정상적인 접근입니다. 로그인 후 이용해주세요");
			resp.sendRedirect(req.getContextPath());
		}
		
	}


}
