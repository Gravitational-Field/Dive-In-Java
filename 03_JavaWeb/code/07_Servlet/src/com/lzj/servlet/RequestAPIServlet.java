package com.lzj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestAPIServlet")
public class RequestAPIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestAPIServlet 的doPost方法！");
    }

    /**
    * @author: keen
    * @Date: 2020/11/16 17:57
    * @Description: 测试HttpServletRequest类方法
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求的 统一资源路径
        System.out.println("URI：" + request.getRequestURI());  //URI：/07_Servlet/requestAPIServlet
        //2. 获取请求的 统一资源定位符
        System.out.println("URL：" + request.getRequestURL());  //URL：http://localhost:8080/07_Servlet/requestAPIServlet
        //3. 获取客户端的ip地址
        System.out.println("客户端的ip地址：" + request.getRemoteHost());   //客户端的ip地址：127.0.0.1
        //4. 获取请求方式GET或POST
        System.out.println("客户端的请求方式：" + request.getMethod());  //客户端的请求方式GET
        //5. 获取请求头
        System.out.println("获取请求头：" + request.getHeader("User-Agent"));
        //6. 获取服务器解析地址    D:\微云同步助手\810968336\Java\JavaWeb\out\artifacts\07_Servlet_war_exploded\
        System.out.println("获取服务器解析地址" + request.getRealPath("/"));

    }
}
