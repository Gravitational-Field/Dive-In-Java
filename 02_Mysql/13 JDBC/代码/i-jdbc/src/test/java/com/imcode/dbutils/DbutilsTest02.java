package com.imcode.dbutils;

import com.imcode.common.util.DBUtil;
import com.imcode.sys.model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DbutilsTest02 {

    @Test
    public void test01() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        // 如果手动传入数据库连接，需要手动关闭
        queryRunner.update(conn, "DELETE FROM t_user WHERE id = 2");
        DBUtil.close(conn);
    }

    @Test
    public void test02() {
        QueryRunner queryRunner = new QueryRunner();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            queryRunner.update(conn, "UPDATE t_account SET money = money - 100 WHERE account='A'");
            queryRunner.update(conn, "UPDATE t_account SET money = money + 100 WHERE account='B'");
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
    }

    @Test
    public void test03() throws SQLException {
        // QueryRunner 从数据源获取数据库连接，不需要程序手动控制连接
        // 程序员不需要维护数据库连接，不能手动控制事务
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        queryRunner
                .update("UPDATE t_account SET money = money - 100 WHERE account='A'");
    }

    @Test
    public void test04() throws SQLException {
        // QueryRunner 从数据源获取数据库连接，不需要程序手动控制连接
        // 程序员不需要维护数据库连接，不能手动控制事务
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        queryRunner
                .update("UPDATE t_user SET password = ? WHERE username = ? AND email = ?",
                        "111111", "admin", "admin@126.com");
    }


    @Test
    public void test05() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT id,username,password,email,mobile, create_time createTime, update_time updateTime FROM t_user WHERE id=1";
        User user = queryRunner.query(sql, new BeanHandler<>(User.class));
        System.out.println(user);
        // 映射关系的建立，不是通过对象的属性名称和数据库列名建立映射
        // 而是通过setXxx() 方法来建立映射
        // setXxx  去掉set  将第一个X 转小写，去和数据库的列名匹配
        // setCreate_time -- > create_time
    }

    @Test
    public void test06() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT id,username,password,email,mobile, create_time createTime, update_time updateTime FROM t_user";
        List<User> list = queryRunner.query(sql, new BeanListHandler<>(User.class));
        System.out.println(list);
    }

    @Test
    public void test07() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT * FROM t_user WHERE id=1";
        Object[] arr = queryRunner.query(sql, new ArrayHandler());
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test08() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT * FROM t_user";
        List<Object[]> list = queryRunner.query(sql, new ArrayListHandler());
        for (Object[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }


    @Test
    public void test09() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT * FROM t_user WHERE id=1";
        Map<String,Object> map = queryRunner.query(sql,new MapHandler());
        for (String key : map.keySet()) {
            System.out.println(key + "-->" + map.get(key));
        }
    }

    @Test
    public void test10() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT * FROM t_user";
        List<Map<String,Object>> list = queryRunner.query(sql,new MapListHandler());
        for (Map<String,Object> map : list) {
            for (String key : map.keySet()) {
                System.out.print(key + ":" + map.get(key) + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test11() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        //java.lang.Long cannot be cast to java.lang.Integer
        String sql
                = "SELECT count(*) FROM t_user";
        Long count = queryRunner.query(sql, new ScalarHandler<>());
        System.out.println(count);
    }

    @Test
    public void test12() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT * FROM t_user ORDER BY id desc";
        String username = queryRunner.query(sql, new ScalarHandler<>("username"));
        System.out.println(username);
    }


//select count(*) from t_table;  结果集是单列一条
//SELECT username FROM t_user

    @Test
    public void test13() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT username FROM t_user";
        List<String> list = queryRunner.query(sql,new ColumnListHandler<>());
        System.out.println(list);

    }

    @Test
    public void test14() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT * FROM t_user";
        List<String> list = queryRunner.query(sql,new ColumnListHandler<>("email"));
        System.out.println(list);
    }
}








