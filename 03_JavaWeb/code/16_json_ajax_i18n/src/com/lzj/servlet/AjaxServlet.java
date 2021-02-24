package com.lzj.servlet;

import com.google.gson.Gson;
import com.lzj.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AjaxServlet
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/1/5 16:36
 * @Version 1.0
 **/
public class AjaxServlet extends BaseServlet {

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax请求过来了");
        resp.setCharacterEncoding("utf-8");
        Person person = new Person(1, "贝贝");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        //采用json字符串格式进行前后端数据的传递
        resp.getWriter().write(personJsonString);

    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("  jQueryAjax == 方法调用了");
        resp.setCharacterEncoding("utf-8");
        Person person = new Person(1, "贝贝");
        // json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("  jQueryGet  == 方法调用了");
        resp.setCharacterEncoding("utf-8");
        Person person = new Person(1, "贝贝");
        // json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("  jQueryPost   == 方法调用了");
        resp.setCharacterEncoding("utf-8");
        Person person = new Person(1, "贝贝");
        // json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }


    protected void jQueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("  jQueryGetJSON   == 方法调用了");
        resp.setCharacterEncoding("utf-8");
        Person person = new Person(1, "贝贝");
        // json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("  jQuerySerialize   == 方法调用了");
        resp.setCharacterEncoding("utf-8");
        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码：" + req.getParameter("password"));

        Person person = new Person(1, "贝贝");
        // json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

}
