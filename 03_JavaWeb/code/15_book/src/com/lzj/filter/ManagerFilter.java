package com.lzj.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行到ManagerFilter的doFilter中");
        //将两者进行一个转换
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Object user = req.getSession().getAttribute("user");
        if(user == null) {
            //没有登录，则先去登陆
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }else {
            //已经登录成功
            filterChain.doFilter(servletRequest, servletResponse); //进行下一个过滤或者到请求出请求
        }
    }

    @Override
    public void destroy() {

    }
}
