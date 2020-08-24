package com.imcode;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo02 {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(DBCPDemo02.class.getClassLoader().getResourceAsStream("db.properties"));

        //1.初始化数据库连接池(数据源)对象
        DataSource dataSource =
                DruidDataSourceFactory.createDataSource(prop);

        //2.获取数据库连接
        Connection conn = dataSource.getConnection();
        conn.close();
    }
}
