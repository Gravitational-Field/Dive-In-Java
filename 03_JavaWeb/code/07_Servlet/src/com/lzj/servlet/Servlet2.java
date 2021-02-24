package com.lzj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet2 的doGet方法");
        String username = req.getParameter("username");
        System.out.println("在 Servlet2（柜台 2）中查看参数（材料）" + username);

        Object key1 = req.getAttribute("key1");
        System.out.println("柜台 1 是否有章：" + key1);

        System.out.println("Servlet2 处理自己的业务 ");

    }
}
