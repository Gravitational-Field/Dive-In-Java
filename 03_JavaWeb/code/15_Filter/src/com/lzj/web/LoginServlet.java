package com.lzj.web;

import com.lzj.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "LoginServlet",value = "/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        if("root".equals(username)) {
            req.getSession().setAttribute("user",username);
            //跳转到ok.jsp页面
            req.getRequestDispatcher("/ok.jsp").forward(req, resp);
            return;
        }
        //登录失败
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
