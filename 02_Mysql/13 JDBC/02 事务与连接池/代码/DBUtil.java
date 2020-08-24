package com.imcode.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private static DataSource dataSource;

    static {
        try {
            Properties prop = new Properties();
            InputStream in =
                    DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(in);
            in.close();
            // 初始化数据库连接池
            dataSource = DruidDataSourceFactory.createDataSource(prop);
            System.out.println("初始化数据源....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从数据源获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 关闭数据库连接
     *
     * @param conn
     */
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库连接
     *
     * @param conn
     * @param st
     */
    public static void close(Connection conn, Statement st) {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库连接
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void close(Connection conn, Statement st, ResultSet rs) {
        close(conn, st);
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     *
     * @param conn
     */
    public static void commit(Connection conn) {
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     *
     * @param conn
     */
    public static void rollback(Connection conn) {
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用来执行 新增，修改、删除
     * @param conn
     * @param sql
     * @return
     */
    public static int update(Connection conn, String sql) {
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            int r = ps.executeUpdate();
            ps.close();
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
