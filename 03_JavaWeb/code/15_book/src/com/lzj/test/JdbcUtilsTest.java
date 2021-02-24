package com.lzj.test;

import com.lzj.util.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {

    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection); //最多有10个
            //JdbcUtils.close(connection);
            System.out.println(connection);
        }
    }
}
