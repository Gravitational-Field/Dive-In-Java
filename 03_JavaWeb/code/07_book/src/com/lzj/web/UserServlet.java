package com.lzj.web;

import com.lzj.pojo.User;
import com.lzj.service.UserService;
import com.lzj.service.impl.UserServiceImpl;
import com.lzj.test.UserServletTest;
import com.lzj.util.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    private UserService userService= new UserServiceImpl();

    
    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的参数
        //String username = req.getParameter("username");
        //String password = req.getParameter("password");
        //String email = req.getParameter("email");

        //验证码01. 获取session中的谷歌验证码的token
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());


        //2. 检查验证码
        if(token != null && token.equalsIgnoreCase(code)){
            //验证码成立
            if(userService.exitsUsername(user.getUsername())){
                //用户名已存在
                System.out.println("用户名["+ user.getUsername() +"]已经存在！");
                req.setAttribute("msg","用户名["+ user.getUsername() +"]已经存在！");
                req.setAttribute("username",user.getUsername());
                req.setAttribute("email",user.getEmail());
                //请求的转发
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else {
                //用户名不存在,进行注册，并保存
                userService.registUser(new User(null, user.getUsername(), user.getPassword(), user.getEmail()));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //验证码不成立
            System.out.println("验证码["+code+"]输入错误！");
            req.setAttribute("msg","验证码输入错误！");
            req.setAttribute("username",user.getUsername());
            req.setAttribute("email",user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String username = req.getParameter("username");
        //String password = req.getParameter("password");
        User user1 = WebUtils.copyParamToBean(req.getParameterMap(),new User());

        User user = userService.login(user1);

        if(user == null){
            //没有找到用户
            System.out.println("没有找到用户["+user1.getUsername()+"]!");
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",user1.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            //找到相应用户
            System.out.println(user);
            //req.setAttribute("user",user);
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    /**
    * @author: Keen
    * @Description:注销操作
    */
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 删除session中的登录user信息  (也可以使session销毁)
        req.getSession().removeAttribute("user");
        //req.getSession().invalidate();
        //2. 跳转到首页面
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
}
