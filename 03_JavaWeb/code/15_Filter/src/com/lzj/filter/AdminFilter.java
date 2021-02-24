package com.lzj.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "AdminFilter",value = "/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AdminFilter过滤器被创建...");
        System.out.println(filterConfig.getServletContext());
    }

    /**
    * @author: Keen
    * @Description:用于专门拦截请求
    */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将两者进行一个转换
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Object user = req.getSession().getAttribute("user");
        if(user == null) {
            //没有登录，则先去登陆
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }else {
            //已经登录成功
            filterChain.doFilter(servletRequest, servletResponse); //然后就能成功的转到 /admin/1.html
        }
        System.out.println("AdminFilter中doFilter最后的代码...");
    }

    @Override
    public void destroy() {
        System.out.println("AdminFilter过滤器被销毁...");
    }
}
