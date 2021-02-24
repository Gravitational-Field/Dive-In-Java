package com.lzj.web;

import com.lzj.pojo.User;
import com.lzj.service.UserService;
import com.lzj.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2. 检查验证码
        if("abcd".equalsIgnoreCase(code)){
            //验证码成立
            if(userService.exitsUsername(username)){
                //用户名已存在
                System.out.println("用户名["+ username +"]已经存在！");
                req.setAttribute("msg","用户名["+ username +"]已经存在！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                //重定向至原页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else {
                //用户名不存在,进行注册，并保存
                userService.registUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //验证码不成立
            System.out.println("验证码["+code+"]输入错误！");
            req.setAttribute("msg","验证码输入错误！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
