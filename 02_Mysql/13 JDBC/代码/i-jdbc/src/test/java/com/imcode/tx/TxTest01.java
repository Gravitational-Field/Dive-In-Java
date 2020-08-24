package com.imcode.tx;

import com.imcode.common.util.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TxTest01 {
    @Test
    public void test01() {
        Connection conn = null;
        Statement st = null;
        try {
            //1.获取数据库连接
            conn = DBUtil.getConnection();
            // 在获取到连接之间，执行SQL语句之前，设置事务手动提交
            conn.setAutoCommit(false);
            st = conn.createStatement();
            String sql1 = "UPDATE t_account SET money = money - 100 WHERE account = 'A'";
            String sql2 = "UPDATE t_account SET money = money + 100 WHERE account = 'B'";
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);
            int i = 100/0;
            // 手动提交事务
            conn.commit();
        } catch (Exception e) {
            // 回滚事务
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,st);
        }
    }
}
