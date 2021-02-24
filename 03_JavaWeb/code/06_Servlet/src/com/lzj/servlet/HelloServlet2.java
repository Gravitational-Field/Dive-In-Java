package com.lzj.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("HelloServlet init 初始化方法");

        System.out.println("HelloServlet程序的别名为：" + config.getServletName());
        System.out.println("初始化参数 username 的值为：" + config.getInitParameter("username"));
        System.out.println("初始化参数 url 的值为：" + config.getInitParameter("url"));

        System.out.println(config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doGet方法！"); //默认是doGet方法
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doPost方法！");
    }
}
