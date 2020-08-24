package com.imcode.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
     * 获取数据源
     *
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
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
     * 调用该方法后必须手动关闭数据库连接
     * 用于需要手动控制事务的情况
     *
     * @param conn
     * @param sql
     * @return
     */
    public static int update(Connection conn, String sql, Object... param) {
        try {
            QueryRunner runner = new QueryRunner();
            return runner.update(conn, sql, param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 用来执行 新增，修改、删除
     * 调用该方法不需要管理数据库连接和事务
     * 不需要事务控制的时候使用
     *
     * @param sql
     * @return
     */
    public static int update(String sql, Object... param) {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            return runner.update(sql, param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * 查询单个对象
     * @param sql
     * @param cls
     * @param param
     * @param <T>
     * @return
     */
    public static <T> T queryOne(String sql, Class<T> cls, Object... param) {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            return runner.query(sql, new BeanHandler<>(cls), param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询多条数据
     * @param sql
     * @param cls
     * @param param
     * @param <T>
     * @return
     */
    public static <T> List<T> queryList(String sql, Class<T> cls, Object... param) {
        try {
            QueryRunner runner = new QueryRunner(dataSource);
            return runner.query(sql, new BeanListHandler<>(cls), param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
