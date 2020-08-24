package com.imcode.common.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DBUtil {
    private static DataSource dataSource;
    private static QueryRunner queryRunner;

    static {
        try {
            // 完成数据库连接池的初始化
            Properties prop = new Properties();
            InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("application.properties");
            prop.load(in);
            in.close();
            // 创建数据库连接池
            dataSource = DruidDataSourceFactory.createDataSource(prop);
            queryRunner = new QueryRunner(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回单个对象
     *
     * @param type
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T queryOne(Class<? extends T> type, String sql, Object... params) {
        try {
            return queryRunner.query(sql, new BeanHandler<>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回对象的集合
     *
     * @param type
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> queryList(Class<? extends T> type, String sql, Object... params) {
        try {
            return queryRunner.query(sql, new BeanListHandler<>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 自动提交事务的新增、修改、删除
     *
     * @param sql
     * @param params
     */
    public static void update(String sql, Object... params) {
        try {
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Connection conn, String sql, Object... params) {
        try {
            queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据源
     *
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获取数据库连接
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
     * 释放资源
     *
     * @param conn
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     *
     * @param conn
     * @param st
     */
    public static void close(Connection conn, Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(conn);
    }

    /**
     * 释放资源
     *
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