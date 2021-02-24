package com.xdl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("*.do")
public class XdlCheckLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse  response,
		FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest  hrequest = (HttpServletRequest)request;
		HttpServletResponse hresponse = (HttpServletResponse)response;
		String servletPath  = hrequest.getServletPath();
		if("/login.do".equals(servletPath)){
			// 放行 
			chain.doFilter(request, response);
		}else{
			// 判断session 中是否有 acc_no
			HttpSession  session = hrequest.getSession();
			Object  obj = session.getAttribute("acc_no");
			if(obj != null){
				// 放行 
				chain.doFilter(request, response);
			}else{
				// 跳转到登录页面 
				hresponse.sendRedirect("login.jsp");
			}
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
