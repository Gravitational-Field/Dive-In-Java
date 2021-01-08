package com.lzj.dao.impl;


import com.lzj.dao.UserDao;
import com.lzj.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User queryUserByUsername(String username) {
        String sql = "SELECT id,username,PASSWORD,email FROM t_user WHERE username = ?";

        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT id,username,PASSWORD,email FROM t_user WHERE username = ? AND PASSWORD = ?";

        return queryForOne(User.class,sql, username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO t_user(username,PASSWORD,email) VALUES(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
