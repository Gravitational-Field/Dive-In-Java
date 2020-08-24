package com.imcode;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DruidDemo01 {
    public static void main(String[] args) throws SQLException {
        //1.初始化数据库连接池(数据源)对象
        //BasicDataSource dataSource = new BasicDataSource();
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
        dataSource.setUsername("app");
        dataSource.setPassword("123456");

        //2.从连接池中获取数据库连接
        Connection conn = dataSource.getConnection();

        //3.释放连接对象 放回连接池
        conn.close();
    }
}
