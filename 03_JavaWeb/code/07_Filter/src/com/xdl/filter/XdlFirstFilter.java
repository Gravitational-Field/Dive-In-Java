package com.xdl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class XdlFirstFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain  chain)throws IOException, ServletException {
		System.out.println("此树是我栽 此路是我开 要想从此过  留下买路财");
		// 放行代码 
		chain.doFilter(request, response);
		System.out.println("你回来了啊,你交过过路费了  我就不再拦你了");
		
	}

	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
