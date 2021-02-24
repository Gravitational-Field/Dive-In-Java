package com.lzj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @author: keen
* @Date: 2020/11/17 9:48
* @Description: 重定向
*/
public class Response1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Response1Servlet doGet方法！");
        //重定向方法 1.
        //resp.setStatus(302);
        //resp.setHeader("Location","http://localhost:8080/07_Servlet/response2Servlet");
        //重定向方法 2.
        resp.sendRedirect("http://localhost:8080/07_Servlet/response2Servlet");
        System.out.println(req.getLocalAddr());
    }
}
