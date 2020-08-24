package com.imcode.test;

import com.imcode.model.Clazz;
import com.imcode.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 调用query方法不需要关闭数据库连接，dbutis工具类会帮我们关闭
 */
public class DBUtilTest01 {

    /**
     * 测试查询
     */
    @Test
    public void test01() throws SQLException {

        QueryRunner runner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        String sql = "select id,class_number classNumber,class_name className from t_class where id = 1002";
        //将结果集中第一条记录封装到一个指定的java对象中。
        Clazz clazz = runner.query(conn, sql, new BeanHandler<>(Clazz.class));
        System.out.println(clazz);
    }


    /**
     * 测试查询
     */
    @Test
    public void test03() throws SQLException {

        QueryRunner runner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        String sql = "select id,class_number classNumber,class_name className from t_class where id = ?";
        //将结果集中第一条记录封装到一个指定的java对象中。
        Clazz clazz = runner.query(conn, sql, new BeanHandler<>(Clazz.class), 1002);
        System.out.println(clazz);
    }


    @Test
    public void test02() throws SQLException {

        QueryRunner runner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        String sql = "select id,class_number classNumber,class_name className from t_class";

        //将结果集中每一条记录封装到指定的javaBean中，将这些javaBean在封装到List集合中
        List<Clazz> list = runner.query(conn, sql, new BeanListHandler<>(Clazz.class));
        for (Clazz c : list) {
            System.out.println(c);
        }

    }


    @Test
    public void test04() throws SQLException {

        QueryRunner runner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        String sql = "select id,class_number classNumber,class_name className from t_class where id = ?";
        //将结果集中的第一条记录封装到一个Object[]数组中，数组中的每一个元素就是这条记录中的每一个字段的值
        Object[] objects = runner.query(conn, sql, new ArrayHandler(), 1002);
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }

    @Test
    public void test05() throws SQLException {

        QueryRunner runner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        String sql = "select id,class_number classNumber,class_name className from t_class";
        //将结果集中的每一条记录都封装到一个Object[]数组中，将这些数组在封装到List集合中。
        List<Object[]> list = runner.query(conn, sql, new ArrayListHandler());
        for (Object[] objects : list) {
            for (Object obj : objects) {
                System.out.print(obj + " ");
            }
            System.out.println();
        }
    }


    @Test
    public void test06() throws SQLException {

        QueryRunner runner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        String sql = "select id,class_number classNumber,class_name className from t_class where id = ?";
        //将结果集第一行封装到Map集合中,Key 列名, Value 该列数据
        Map<String, Object> map = runner.query(conn, sql, new MapHandler(), 1002);
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }

    @Test
    public void test07() throws SQLException {

        QueryRunner runner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        String sql = "select id,class_number classNumber,class_name className from t_class";
        //将结果集第一行封装到Map集合中,Key 列名, Value 该列数据
        List<Map<String, Object>> list = runner.query(conn, sql, new MapListHandler());

        for (Map<String, Object> map : list) {
            for (String key : map.keySet()) {
                System.out.println(key + ":" + map.get(key));
            }
            System.out.println("------------------");
        }

    }

    @Test
    public void test08() throws SQLException {

        QueryRunner runner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        String sql = "select count(*) from t_class";
        //它是用于单数据。例如select count(*) from 表操作
        BigDecimal count = runner.query(conn, sql, new ScalarHandler<BigDecimal>());
        System.out.println(count);
    }

    @Test
    public void test09() throws SQLException {

        QueryRunner runner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        String sql = "select class_name from t_class";
        //将结果集中指定的列的字段值，封装到一个List集合中
        List<String> list = runner.query(conn, sql, new ColumnListHandler<>());
        for (String name : list) {
            System.out.println(name);
        }
    }

    @Test
    public void test10() throws SQLException {

        QueryRunner runner = new QueryRunner(DBUtil.getDataSource());

        String sql = "select id,class_number classNumber,class_name className from t_class";
        //将结果集中每一条记录封装到指定的javaBean中，将这些javaBean在封装到List集合中
        List<Clazz> list = runner.query(sql, new BeanListHandler<>(Clazz.class));
        for (Clazz c : list) {
            System.out.println(c);
        }
    }
}
