package com.lzj.servlet;

import com.lzj.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SearchStudentServlet", value="/searchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从数据库中获取数据
        System.out.println("hahah");
        ArrayList<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int t = i+1;
            studentList.add(new Student(t,"name"+t,18+t,"phone"+t));
        }
        //将数据存进request域中
        request.setAttribute("stuList", studentList);
        //请求转发
        request.getRequestDispatcher("/test/showStudent.jsp").forward(request,response);
    }
}
