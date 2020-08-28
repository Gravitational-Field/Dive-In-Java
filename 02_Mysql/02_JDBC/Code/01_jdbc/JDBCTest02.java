package com.imcode.jdbc;

import org.junit.Test;

import java.sql.*;

public class JDBCTest02 {
    @Test
    public void test01() throws Exception {
        getByTest("JAVA01",2);
    }

    public void getByTest(String name,int id) throws Exception {
        //1.加载驱动  将jdbc驱动包中的一些类加载到jvm中 反射的方式加载
        Class.forName("com.mysql.jdbc.Driver");
        //2.与数据库建立连接
        String url = "jdbc:mysql://localhost:3306/myapp?useSSL=false&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "SELECT * FROM t_class WHERE name = ? OR id = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        // 设值参数的值
        pst.setString(1,name);
        pst.setInt(2,id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "|" +
                    rs.getString("name"));
        }
        rs.close();
        pst.close();
        conn.close();
    }
}
