package com.lzj.service;

import com.lzj.pojo.User;

public interface UserService {

    /**
    * @Description: 登录验证
    * @Params: user
    * @Return:
    */
    public User login(User user);

    public void registUser(User user);

    public boolean exitsUsername(String username);

}
