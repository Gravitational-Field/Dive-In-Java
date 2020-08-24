package com.imcode.test;

import com.imcode.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilTest03 {

    @Test
    public void test01() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        String sql = "insert into t_class(id,class_number,class_name) values (?,?,?)";
        runner.update(conn,sql,100010,"T0010","T0010");
        DBUtil.close(conn);
    }
}
