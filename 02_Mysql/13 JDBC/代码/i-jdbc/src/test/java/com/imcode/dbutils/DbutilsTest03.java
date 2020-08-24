package com.imcode.dbutils;

import com.imcode.common.util.DBUtil;
import com.imcode.sys.model.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DbutilsTest03 {

    @Test
    public void test01() throws SQLException {
        String sql = "SELECT * FROM t_user WHERE id = ?";
        User user = DBUtil.queryOne(User.class, sql, 1);
        System.out.println(user);
    }

    @Test
    public void test02() throws SQLException {
        String sql = "SELECT * FROM t_user WHERE email=? and mobile=?";
        User user = DBUtil.queryOne(User.class, sql, "admin@126.com", "13888888888");
        System.out.println(user);
    }

    @Test
    public void test03() throws SQLException {
        String sql = "SELECT * FROM t_user";
        List<User> list = DBUtil.queryList(User.class, sql);
        System.out.println(list);
    }

    @Test
    public void test04() {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "INSERT INTO t_account VALUES(?,?)";
            conn.setAutoCommit(false);
            DBUtil.update(conn, sql, "H", 250.5);
            int i = 100/0;
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
    }
}








