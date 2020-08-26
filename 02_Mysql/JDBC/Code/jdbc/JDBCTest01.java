package com.imcode.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest01 {
    @Test
    public void test01() throws Exception {
        //1.加载驱动  将jdbc驱动包中的一些类加载到jvm中 反射的方式加载
        //Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //2.与数据库建立连接
        String url = "jdbc:mysql://localhost:3306/myapp?useSSL=false&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        //发送操作数据库的SQL语句
        String sql = "SELECT id c_id, name c_name FROM t_class";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        //处理SQL执行结果
        while (rs.next()) {
//            System.out.print(rs.getInt("id"));
//            System.out.println("|" + rs.getString("name"));
            System.out.print(rs.getInt("c_id"));
            System.out.println("|" + rs.getString("c_name"));
//            System.out.print(rs.getInt(1));
//            System.out.println("|" + rs.getString(2));
        }
        //释放数据库资源
        rs.close();
        st.close();
        conn.close();
    }

    @Test
    public void test02() throws Exception {
        //1.加载驱动  将jdbc驱动包中的一些类加载到jvm中 反射的方式加载
        Class.forName("com.mysql.jdbc.Driver");
        //2.与数据库建立连接
        String url = "jdbc:mysql://localhost:3306/myapp?useSSL=false&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3.发送操作数据库的SQL语句
        Statement st = conn.createStatement();
        //String sql = "INSERT INTO t_class(id,`name`) VALUES(6,'JAVA06')";
        String sql = "INSERT INTO t_class(`name`) VALUES('JAVAEE08')";
        int result = st.executeUpdate(sql); // 用于执行 插入、修改、和删除类的SQL ,返回影响的数据条数
        System.out.println("影响的行数:" + result);
        //4.释放数据库资源
        st.close();
        conn.close();
    }

    @Test
    public void test03() throws Exception {
        //1.加载驱动  将jdbc驱动包中的一些类加载到jvm中 反射的方式加载
        Class.forName("com.mysql.jdbc.Driver");
        //2.与数据库建立连接
        String url = "jdbc:mysql://localhost:3306/myapp?useSSL=false&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.发送操作数据库的SQL语句
        Statement st = conn.createStatement();
        String sql = "UPDATE t_class SET `name`=CONCAT('JAVA0',id) WHERE `name` LIKE 'JAVAEE%'";
        int result = st.executeUpdate(sql); // 用于执行 插入、修改、和删除类的SQL ,返回影响的数据条数
        System.out.println("影响的行数:" + result);
        //4.释放数据库资源
        st.close();
        conn.close();
    }

    @Test
    public void test04() throws Exception {
        //1.加载驱动  将jdbc驱动包中的一些类加载到jvm中 反射的方式加载
        Class.forName("com.mysql.jdbc.Driver");
        //2.与数据库建立连接
        String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.发送操作数据库的SQL语句
        Statement st = conn.createStatement();
        String sql = "DELETE FROM t_class WHERE id=8";
        int result = st.executeUpdate(sql); // 用于执行 插入、修改、和删除类的SQL ,返回影响的数据条数
        System.out.println("影响的行数:" + result);
        //4.释放数据库资源
        st.close();
        conn.close();
    }
}
