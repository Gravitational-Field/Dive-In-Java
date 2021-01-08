package com.lzj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "ParameterServlet")
public class ParameterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求体的字符集为 UTF-8，从而解决 post 请求的中文乱码问题
        //必须在获取请求参数之前调用才有效
        //request.setCharacterEncoding("UTF-8");
        System.out.println("-------------doPost------------");
        // 获取请求参数
        String username = request.getParameter("username");
        //username = new String(username.getBytes("iso-8859-1"),"utf-8");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("兴趣爱好：" + Arrays.asList(hobby));
    }

    /**
     * @author: keen
     * @Date: 2020/11/16 18:32
     * @Description: 获取请求参数
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-------------doGet------------");
        String username = request.getParameter("username");
        //解决doGet请求中的中文乱码问题
        //username = new String(username.getBytes("iso-8859-1"), "utf-8");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");

        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("兴趣爱好：" + Arrays.asList(hobby));

    }
}
