package com.imcode.dbutils;

import com.imcode.common.util.DBUtil;
import com.imcode.sys.model.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbutilsTest01 {

    @Test
    public void test01() {
        User user = getById(1);
        System.out.println(user);
    }

    public User getById(Integer userId) {
        // 通过id查询用户详细信息
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            // 1.获取数据库连接
            conn = DBUtil.getConnection();
            // 2.获取sql执行对象
            pst = conn.prepareStatement("SELECT * FROM t_user WHERE id = ?");
            // 3.设置参数
            pst.setInt(1, userId);
            // 4.获取结果集
            rs = pst.executeQuery();
            // 5.处理结果集
            if (rs.next()) {
                Integer id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String mobile = rs.getString("mobile");
                Date createTime = rs.getDate("create_time");
                Date updateTime = rs.getDate("create_time");
                User user = new User();
                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                user.setMobile(mobile);
                user.setCreateTime(createTime);
                user.setUpdateTime(updateTime);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6.释放资源
            DBUtil.close(conn, pst, rs);
        }
        return null;
    }
}
