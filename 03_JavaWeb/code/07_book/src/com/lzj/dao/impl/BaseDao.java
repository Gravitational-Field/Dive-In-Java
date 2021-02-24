package com.lzj.dao.impl;

import com.lzj.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //使用DBUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    //1. update操作: 增 删 改
    public int update(String sql,Object ...args) {
        Connection connection = JdbcUtils.getConnection();

        try {
            //正确返回 1，没有改变 返回0，错误就抛出异常
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    //2. 查询一个javaBean的操作
    public <T> T queryForOne(Class<T> type,String sql,Object ...args) {
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    //3. 查询多个JavaBean的操作
    public <T> List<T> queryForList(Class<T> type, String sql, Object ...args) {

        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    //4. 查询返回一列的操作
    public Object querySingleValue(String sql, Object ...args) {
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

}
