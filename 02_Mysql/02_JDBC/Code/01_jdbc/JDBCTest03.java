package com.imcode.jdbc;

import com.imcode.common.util.DBUtil_v1;
import org.junit.Test;

import java.sql.*;

public class JDBCTest03 {
    @Test
    public void test01() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //1.加载驱动  将jdbc驱动包中的一些类加载到jvm中 反射的方式加载
            Class.forName("com.mysql.jdbc.Driver");
            //2.与数据库建立连接
            String url = "jdbc:mysql://localhost:3306/myapp?useSSL=false&serverTimezone=Asia/Shanghai";
            String username = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, username, password);
            //发送操作数据库的SQL语句
            String sql = "SELECT * FROM t_class";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //处理SQL执行结果
            while (rs.next()) {
                System.out.print(rs.getInt("id"));
                System.out.println("|" + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放数据库资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void test02() {
        //1.获取数据库连接
        Connection conn = DBUtil_v1.getConnection();
        try {
            PreparedStatement pst =
                    conn.prepareStatement("SELECT * FROM t_student WHERE name LIKE ? AND age > ?");
            // 设置参数
            pst.setString(1, "王%");
            pst.setInt(2, 16);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            // 释放资源
            DBUtil_v1.close(conn, pst, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test03() {
        //1.获取数据库连接
        Connection conn = DBUtil_v1.getConnection();
        try {
            String sql
                    = "INSERT INTO cms_news (title,intro,content,source,tags,url,publish_time) VALUES (?,?,?,?,?,?,?)";
            // 设置参数
            PreparedStatement pst =
                    conn.prepareStatement(sql);
            pst.setObject(1,"jdbc测试");
            pst.setObject(2,"jdbc测试简介");
            pst.setObject(3,"jdbc测试内容");
            pst.setObject(4,"jdbc测试来源");
            pst.setObject(5,"jdbc测试标签");
            pst.setObject(6,"jdbc测试链接");
            //pst.setObject(7,"2020-10-19 18:20:30");
            // 只能设置日期
            //pst.setDate(7, new Date(System.currentTimeMillis()));
            // 设置时间
            //pst.setTime(7,new Time(System.currentTimeMillis()));
            pst.setTimestamp(7,new Timestamp(System.currentTimeMillis()));

            // 执行SQL语句
            pst.executeUpdate();
            // 释放资源
            DBUtil_v1.close(conn, pst);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// 无论是否发生异常，都尝试去释放资源
