package com.lzj.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ContextServlet", value = "/context")  //直接new出来的Servlet可以选择带注解
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
        ServletContext servletContext1 = getServletContext();

        String username = servletContext.getInitParameter("username");
        System.out.println("context-param 参数 username 的值是:" + username);
        System.out.println("context-param 参数 password 的值是:" + servletContext.getInitParameter("password"));

        //  / 斜杠被服务器解析地址为:http://ip:port/工程名/        并被映射到 IDEA 代码的 web 目录
        System.out.println("工程目录的部署路径：" + servletContext.getRealPath("/"));
        System.out.println("工程下 css 目录的绝对路径是:" + servletContext.getRealPath("/css"));
        System.out.println("工程下 imgs 目录 1.jpg 的绝对路径是:" + servletContext.getRealPath("/imgs/1.jpg"));
        //context-param 参数 username 的值是:context
        //context-param 参数 password 的值是:root
        //工程目录的部署路径：D:\微云同步助手\810968336\Java\JavaWeb\out\artifacts\06_Servlet_war_exploded\
        //工程下 css 目录的绝对路径是:D:\微云同步助手\810968336\Java\JavaWeb\out\artifacts\06_Servlet_war_exploded\css
        //工程下 imgs 目录 1.jpg 的绝对路径是:D:\微云同步助手\810968336\Java\JavaWeb\out\artifacts\06_Servlet_war_exploded\imgs\1.jpg

        System.out.println("服务器本地的ip地址" + request.getLocalAddr());
        System.out.println("客户端的ip地址" + request.getRemoteAddr());  //nginx反向代理传来的地址无法获取真实的ip地址

    }
}
