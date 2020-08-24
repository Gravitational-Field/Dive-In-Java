package com.imcode;

import com.imcode.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilDemo {
    public static void main(String[] args) throws SQLException {
        //1.获取数据库连接
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        try {
            //2.执行插入SQL
            String sql = "INSERT INTO T_CLASS VALUES(SEQ_T_CLASS_ID.NEXTVAL,'T005','T005')";
            DBUtil.update(conn, sql);
            int i = 100/0;
        }catch (Exception e){
            //回滚事务
            DBUtil.rollback(conn);
            e.printStackTrace();
        }
        //手动提交事务
        DBUtil.commit(conn);
        //3.关闭数据库连接
        DBUtil.close(conn);
    }
}
