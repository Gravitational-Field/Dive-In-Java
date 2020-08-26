package com.imcode.pool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.imcode.common.util.DBUtil_v1;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

public class DruidTest01 {

    @Test
    public void test02() throws Exception {
        // 从数据源工厂获取数据库连接池对象
        Properties prop = new Properties();
        prop.load(DruidTest01.class.getClassLoader().getResourceAsStream("application.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

    }

    @Test
    public void  test01() throws SQLException {
        // 创建一个数据库连接池
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/myapp?useSSL=false&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setMaxActive(10);
        // 从数据库连接池获取数据库连接
        System.out.println("初始化连接数：" + dataSource.getInitialSize());
        System.out.println("最大连接数：" + dataSource.getMaxActive());
        System.out.println("最小空闲连接:" + dataSource.getMinIdle());
        Connection conn = dataSource.getConnection();
        PreparedStatement st = conn.prepareStatement("SELECT * FROM t_class");
        ResultSet rs = st.executeQuery();
        rs.next(); // 走到第一条数据
        System.out.println(rs.getInt("id") + "|" + rs.getString("name"));
        DBUtil_v1.close(conn,st,rs);
    }
}
