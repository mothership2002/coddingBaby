package edu.kh.SemiProject.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import edu.kh.SemiProject.common.wrapper.EncryptWrapper;


@WebFilter(filterName="encrypeFilter", 
			urlPatterns = {"/user/login"})
public class Encrypefilter extends HttpFilter implements Filter {

	public Encrypefilter() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		EncryptWrapper wrapper = new EncryptWrapper(req);
		chain.doFilter(wrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
