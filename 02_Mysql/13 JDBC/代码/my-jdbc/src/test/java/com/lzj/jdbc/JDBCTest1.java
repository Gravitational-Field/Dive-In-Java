package com.lzj.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest1 {

    @Test
    public void test01() throws Exception {
        //查
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "SELECT id c_id, name c_name FROM t_class";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            //System.out.print(resultSet.getInt(1));
            //System.out.println(" | "+resultSet.getString(2));
            System.out.print(resultSet.getInt("c_id")); //以查询结果返回的列名为准
            System.out.println(" | "+resultSet.getString("c_name"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void test02() throws Exception {
        //增
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "INSERT INTO t_class(name) VALUES('JAVA07')";
        Statement statement = connection.createStatement();

        int i = statement.executeUpdate(sql);
        System.out.println("改变了"+i+"行。");

        statement.close();
        connection.close();
    }

    @Test
    public void test03() throws Exception {
        //删
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "DELETE FROM t_class WHERE id=103";
        Statement statement = connection.createStatement();

        int i = statement.executeUpdate(sql);
        System.out.println("改变了"+i+"行。");

        statement.close();
        connection.close();
    }

    @Test
    public void test04() throws Exception {
        //改
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "UPDATE t_class set `name`=CONCAT('JAVA0',id) WHERE id=104";
        Statement statement = connection.createStatement();

        int i = statement.executeUpdate(sql);
        System.out.println("改变了"+i+"行。");

        statement.close();
        connection.close();
    }
}
