package com.lzj.test;

import com.lzj.dao.UserDao;
import com.lzj.dao.impl.UserDaoImpl;
import com.lzj.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        User user =userDao.queryUserByUsername("admin");
        if (user == null) {
            System.out.println("用户名可用！");
        } else {
            //System.out.println("用户名已存在！");
            System.out.println(user);
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userDao.queryUserByUsernameAndPassword("root","123456"));
    }

    @Test
    public void saveDao() {
        System.out.println(userDao.saveUser(new User(null, "keen", "123456", "234@s.q")));
    }
}
