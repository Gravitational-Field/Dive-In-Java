package com.imcode.common.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil_v1 {

    private static Properties prop;
    private static final String JDBC_DRIVER_NAME = "jdbc.driverClassName";
    private static final String JDBC_URL = "jdbc.url";
    private static final String JDBC_USERNAME= "jdbc.username";
    private static final String JDBC_PASSWORD = "jdbc.password";

    static {
        try {
            // 读取配置文件 只读取一次
            prop = new Properties();
            InputStream in = DBUtil_v1.class.getClassLoader().getResourceAsStream("application.properties");
            prop.load(in);
            in.close();
            //加载驱动，保证驱动程序只注册一次
            Class.forName(prop.getProperty(JDBC_DRIVER_NAME));
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
            conn = DriverManager.getConnection(
                    prop.getProperty(JDBC_URL),
                    prop.getProperty(JDBC_USERNAME),
                    prop.getProperty(JDBC_PASSWORD));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源
     * @param conn
     * @param st
     */
    public static void close(Connection conn, Statement st) {
        if(st!=null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     * @param conn
     * @param st
     * @param rs
     */
    public static void close(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(conn, st);
    }
}