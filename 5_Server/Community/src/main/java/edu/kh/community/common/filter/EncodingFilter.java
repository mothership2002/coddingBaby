package edu.kh.community.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


//webfilter(url)
//필터 클래스 등록
@WebFilter(filterName = "encodingFilter",urlPatterns = "/*")
public class EncodingFilter extends HttpFilter implements Filter {
	
//	client 요청 시 
//	httpServletRequest, httpServletResponse 생성 
//	서블릿에 도달하기 전 특정 코드 수행하는 코드
	
	
	//서버 실행 시 또는 필터 코드 변경 시 필터 객체 자동 생성
	//필터 초기화 메소드
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("문자 인코딩 필터 초기화");
	}
       
	public void destroy() {
		System.out.println("문자 인코딩 필터 제거");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//ServletRequest == HttpservletRequest 부모
		//response 도 마찬가지
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ServletContext application = request.getServletContext();
		String contextPath = ((HttpServletRequest)request).getContextPath();
		application.setAttribute("contextPath", contextPath);
		
		chain.doFilter(request, response);
	}


}
