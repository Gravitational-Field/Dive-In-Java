package com.lzj.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;
    //使用ThreadLocal，绑定conns，来保证数据库操作中数据的一致性。
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {
        try {
            Properties properties = new Properties();
            // 读取 jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建 数据库连接 池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * @author: keen
    * @Date: 2020/11/18 10:16
    * @Description:获取数据库连接
    */
    public static Connection getConnection() {
        Connection connection = conns.get();
        if(connection == null) {
            try {
                connection = dataSource.getConnection();//从数据库连接池中获取连接
                conns.set(connection); // 保存到ThreadLocal对象中，供后面的jdbc操作使用
                connection.setAutoCommit(false); // 设置为手动管理事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
    * @Author: Keen
    * @Date:  20:00  2021/1/4
    * @Description:  提交事务，并关闭连接
    * @param: null
    * @Return
    */
    public static void commitAndClose( ) {
        Connection connection = conns.get();
        if(connection != null) {
            try {
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        // 一定要执行remove操作，否则就会出错。（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
    * @Author: Keen
    * @Date:  20:00  2021/1/4
    * @Description:  当执行业务出现服务器异常时，回滚业务，保持数据的一致性
    * @param: null
    * @Return
    */
    public static void rollbackAndClose( ) {
        Connection connection = conns.get();
        if(connection != null) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        // 一定要执行remove操作，否则就会出错。（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
    * @author: keen
    * @Date: 2020/11/18 10:17
    * @Description:关闭连接，放回数据库连接池
    */
    //public static void close(Connection connection) {
    //    if (connection != null) {
    //        try {
    //            connection.close();
    //        } catch (SQLException throwables) {
    //            throwables.printStackTrace();
    //        }
    //    }
    //}

    // 进行简单测试
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(connection);
    }
}
