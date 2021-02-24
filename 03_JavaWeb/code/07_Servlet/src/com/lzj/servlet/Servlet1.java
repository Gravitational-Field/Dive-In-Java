package com.lzj.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet1 的doGet方法");
        String username = req.getParameter("username");
        req.setAttribute("key1","柜台1的章");

        //  请求转发必须要以斜杠打头，/ 斜杠表示地址为：http://ip:port/工程名/ , 映射到 IDEA 代码的 web 目录
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        requestDispatcher.forward(req,resp);

    }
}
