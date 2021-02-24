package com.xdl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class XdlSecondFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
		FilterChain chain)
			throws IOException, ServletException {
		System.out.println("我是山里的二大王  你从这过 还得交钱");
		chain.doFilter(arg0, arg1);
		System.out.println("我二代王 先放过你  呵呵");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
