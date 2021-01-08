package com.lzj.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author: keen
 * @Date: 2020/11/15 16:10
 * @Description: test ServletConfig类的功能
 * 采用实现Servlet接口的方式来进行发送请求
 */
public class HelloServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 实现接口的不需要重写init方法
        System.out.println("HelloServlet init 初始化方法");

        System.out.println("HelloServlet程序的别名为：" + servletConfig.getServletName());
        System.out.println("初始化参数 username 的值为：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数 url 的值为：" + servletConfig.getInitParameter("url"));

        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet被访问了！！！");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String method = httpServletRequest.getMethod();

        if ("Get".equals(method)) {
            doGet();
        } else {
            doPost();  //默认调用post请求
        }
    }

    public void doGet() {
        System.out.println("HelloServlet doGET请求");
    }

    public void doPost() {
        System.out.println("HelloServlet doPOST请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

}
