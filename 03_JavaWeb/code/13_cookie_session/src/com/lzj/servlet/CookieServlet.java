package com.lzj.servlet;

import com.lzj.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {


    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        Cookie cookie1 = new Cookie("key1", "value1");
        response.addCookie(cookie1);
        response.getWriter().write("Cookie创建成功");
    }

    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            // getName方法返回Cookie的key（名）
            // getValue方法返回Cookie的value值
            response.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
        }

        Cookie iWantCookie = CookieUtils.findCookie("key1", cookies);
        response.getWriter().write("找到了指定的Cookie<br />" + "Cookie[" + iWantCookie.getName() + "=" + iWantCookie.getValue() + "] <br/>");
    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //方法1. 创建一个新的同名cookie
        Cookie cookie = new Cookie("key1", "new_value");
        response.addCookie(cookie);
        response.getWriter().write("cookie的key1值已经被修改了。");

        //方法2.
        Cookie cookie1 = CookieUtils.findCookie("key1", request.getCookies());
        if(cookie1 != null){
            cookie1.setValue("old_value");
            response.addCookie(cookie1);
            response.getWriter().write("cookie的key1值又被修改了。");
        }
    }


    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1); //默认值为-1
        response.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("defaultLife", request.getCookies());
        if(cookie != null){
            cookie.setMaxAge(0); //默认值为-1
            response.addCookie(cookie);
            response.getWriter().write("defaultLife的cookie已经被删除");
        }
    }

    protected void life3600(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("defaultLife", request.getCookies());
        if(cookie != null){
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);
            response.getWriter().write("defaultLife的cookie将存货3600秒（1小时）");
        }
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        // getContextPath() ===>>>> 得到工程路径     可以对通过path进行一个过滤，来确定是否传到服务器
        cookie.setPath( req.getContextPath() + "/abc" );  //===>>>> /工程路径/abc
        resp.addCookie(cookie); resp.getWriter().write("创建了一个带有 Path 路径的 Cookie"); }
}
