package com.imcode.controller;

import com.imcode.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 会员注册
 */
@WebServlet("/member/register")
public class RegisterController extends HttpServlet {

    private MemberService memberService = new MemberService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //跳转到会员注册页面
        request.getRequestDispatcher("/register.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        memberService.regirster(mobile,password);
        response.getWriter().println("register success");
    }
}
