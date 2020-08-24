package com.imcode.jdbc;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropTest {

    @Test
    public void test() throws Exception {
        Properties prop = new Properties();
        InputStream in = PropTest.class.getClassLoader().getResourceAsStream("application.properties");
        //InputStream in = new FileInputStream();
        prop.load(in);
        System.out.println(prop.getProperty("jdbc.username"));
    }
}
// application.properties 只读取一次
