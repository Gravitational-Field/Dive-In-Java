package com.lzj.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResponseIOServlet")
public class ResponseIOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResponseIOServlet 的doPost方法！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(response.getCharacterEncoding());  //ISO-8859-1
        //响应的乱码解决 1.
        //设置服务器字符集
        //response.setCharacterEncoding("UTF-8"); //utf-8
        //通过响应头设置浏览器使用UTF-8字符集
        //response.setHeader("Content-Type","text/html;charset=UTF-8");  //utf-8  大小写均可

        //响应的乱码解决 2.
        // 它会同时设置服务器和客户端都使用 UTF-8 字符集，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(response.getCharacterEncoding());
        PrintWriter writer = response.getWriter();
        //ServletOutputStream outputStream = response.getOutputStream();
        writer.write("respones's content!!!! <br/>"); //html字符串也可以进行解析
        writer.write("我爱你中国");
    }
}
