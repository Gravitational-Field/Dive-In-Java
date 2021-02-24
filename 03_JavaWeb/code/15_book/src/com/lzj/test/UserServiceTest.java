package com.lzj.test;

import com.lzj.pojo.User;
import com.lzj.service.UserService;
import com.lzj.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admin", "123456", "")));
        System.out.println(userService.login(new User(null, "admin", "12345", "")));
    }

    @Test
    public void registUser() {
        //去mysql客户端看结果
        userService.registUser(new User(null, "adidas", "123456", "12@qw.q"));
        userService.registUser(new User(null, "nike", "123456", "12@qw.q"));
    }

    @Test
    public void exitsUsername() {
        System.out.println(userService.exitsUsername("keen"));
        System.out.println(userService.exitsUsername("nike"));
    }
}
