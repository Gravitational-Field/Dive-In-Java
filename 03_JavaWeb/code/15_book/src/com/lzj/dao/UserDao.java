package com.lzj.dao;


import com.lzj.pojo.User;

public interface UserDao {

    /**
    * @Description:根据username查询用户
    * @Param: username 用户名
    * @Return: 返回查询到的User，未查询到则返回null
    */
    public User queryUserByUsername(String username);

    /**
    * @Description:根据username和password查询用户
    * @Param:username 用户名
    * @Param:password 
    * @Return:
    */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
    * @Description:
    * @Params: user 保存的user对象
    * @Return: 返回-1，表示操作失败，其它代表sql语句影响行数
    */
    public int saveUser(User user);


}
