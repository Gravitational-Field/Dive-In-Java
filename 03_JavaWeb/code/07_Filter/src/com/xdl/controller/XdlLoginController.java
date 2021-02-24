package com.xdl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XdlLoginController
 */
public class XdlLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String  acc_no  = request.getParameter("acc_no");
		String  acc_password = request.getParameter("acc_password");
		if("abc".equals(acc_no) && "123".equals(acc_password)){
			request.getSession().setAttribute("acc_no", acc_no);
			System.out.println("登录成功");
			response.sendRedirect("main.jsp");
		}else{
			request.setAttribute("msg", "登录失败");
			System.out.println("登录失败");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}




