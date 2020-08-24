package com.imcode.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    private final static Properties prop;

    static {
        prop = new Properties();
        try {
            InputStream in =
                    DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(in);
            in.close();
            // 加载驱动
            Class.forName(prop.getProperty("driverClassName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //获取数据库连接
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            String url = prop.getProperty("url");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("获取数据库连接成功...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 释放资源
     *
     * @param conn
     * @param st
     */
    public static void close(Connection conn, Statement st) {
        if (conn != null) {
            try {
                conn.close();
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
        System.out.println("释放资源成功....");
    }

    public static void close(Connection conn, Statement st, ResultSet rs) {
        close(conn, st);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("释放资源成功....");
    }


    public static void main(String[] args) {
        Connection conn = DBUtil.getConnection();
        close(conn, null);
    }
}














