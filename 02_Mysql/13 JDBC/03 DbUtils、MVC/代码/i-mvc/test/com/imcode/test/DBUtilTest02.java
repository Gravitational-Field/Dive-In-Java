package com.imcode.test;

import com.imcode.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilTest02 {

    @Test
    public void test01() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        // 不关闭数据库连接
        runner.update(conn,"update t_student set student_name='张三001' where id=1002 ");
        // 手动关闭数据库连接
        DBUtil.close(conn);
    }

    @Test
    public void test02() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        // 不关闭数据库连接
        runner.update(conn,"update t_student set student_name=? where id=? ","张三008",1002);
        conn.commit();
        // 手动关闭数据库连接
        DBUtil.close(conn);
    }


    /**
     * 不需要手动控制事务的时候
     * @throws SQLException
     */
    @Test
    public void test03() throws SQLException {
        QueryRunner runner = new QueryRunner(DBUtil.getDataSource());
        // 不关闭数据库连接
        runner.update("update t_student set student_name=? where id=? ","张三009",1002);
    }
}
