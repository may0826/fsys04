package com.fs.filter;

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

import com.fs.util.GlobalVariables;

public class LoginStatusFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(false);
		
		if(session == null || session.getAttribute(GlobalVariables.USERINFO) == null) {
			//  用户还没有登录 所以不能观看 我的  页面
			
			HttpServletResponse response = (HttpServletResponse)resp;
			response.sendRedirect("login.html");
			return;
		}
		
		chain.doFilter(request, resp);
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
