package com.imcode;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

public class DBCPDemo02 {
    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        prop.load(DBCPDemo02.class.getClassLoader().getResourceAsStream("db.properties"));

        //1.初始化数据库连接池(数据源)对象
        DataSource dataSource =
                BasicDataSourceFactory.createDataSource(prop);

        //2.获取数据库连接
        Connection conn = dataSource.getConnection();
        conn.close();

    }
}
