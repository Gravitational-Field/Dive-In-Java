package com.lzj.service.impl;


import com.lzj.dao.UserDao;
import com.lzj.dao.impl.UserDaoImpl;
import com.lzj.pojo.User;
import com.lzj.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao= new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);  //saveUser返回了个int值 //TODO:看看需要做什么处理
    }

    @Override
    public boolean exitsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return false;
        }
        return true;
    }
}
