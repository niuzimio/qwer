package com.web.teacher.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AuthorFilter implements Filter{


	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("===========������=======");
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		if(uri.endsWith(".css")) {
			chain.doFilter(request,response);
			return;
		}

	
		
		//不合法的请求
		HttpServletResponse resp = (HttpServletResponse)response;
		resp.sendRedirect("/teacher/index.jsp");
		
	
		
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
