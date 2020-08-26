package com.imcode.pool;

import com.imcode.common.util.DBUtil;
import com.imcode.common.util.DBUtil_v1;
import org.junit.Test;

import java.sql.Connection;

public class PoolTest01 {
    @Test
    public void test01() {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            //获取数据库连接
            Connection conn = DBUtil_v1.getConnection();
            //System.out.println("第" + i + "个连接");
            System.out.println(conn);
            DBUtil_v1.close(conn, null);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("执行时间: " + (t2 - t1)); //15342
    }

    @Test
    public void test02() {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            //获取数据库连接
            Connection conn = DBUtil.getConnection();
            //System.out.println("第" + i + "个连接");
            System.out.println(conn);
            //DBUtil.close(conn, null);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("执行时间: " + (t2 - t1)); //588
    }
}
