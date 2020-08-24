package com.imcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 事务控制
 * 手动控制事务
 *
 * 在需要事务控制的SQL执行之前调用  conn.setAutoCommit(false);
 * SQL语句如果全部执行正确 提交事务  conn.commit();
 * 如果出现异常  回滚事务   conn.rollback();
 * 最后释放资源  conn.close(); 如果有未提交的事务，提交事务，关闭数据库连接
 */
public class JDBCDemo04 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
            String username = "app";
            String password = "123456";
            conn = DriverManager.getConnection(url, username, password);
            // 关闭事务的自动提交 手动控制事务
            conn.setAutoCommit(false);

            st = conn.createStatement();
            // 执行转账的动作
            String sql1 = "UPDATE T_ACCOUNT SET MONEY = MONEY - 500 WHERE ACCOUNT='JACK'";
            String sql2 = "UPDATE T_ACCOUNT SET MONEY = MONEY + 500 WHERE ACCOUNT='ROSE'";

            st.executeUpdate(sql1);
            st.executeUpdate(sql2);
            System.out.println("转账已经成功 已经成功 已经成功");
            // 手动提交事务
            conn.commit();

            System.out.println("给两个账户发送成功消息通知");
            int i = 100 / 0;
        } catch (Exception e) {
            // 如果出现异常回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();// 关闭连接的时候事务自动提交
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
