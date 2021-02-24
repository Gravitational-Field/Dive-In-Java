package com.lzj.web;


import com.lzj.pojo.User;
import com.lzj.service.UserService;
import com.lzj.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.login(new User(null,username, password, null));

        if(user == null){
            //没有找到用户
            System.out.println("没有找到用户["+username+"]!");
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            //找到相应用户
            System.out.println(user);
            req.setAttribute("user",user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
