package com.imcode.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitTest {



    @Before
    public void before(){
        System.out.println("init...");
    }

    @Test
    public void test01(){
        System.out.println("测试代码01");
    }

    @Test
    public void test02(){
        System.out.println("测试代码02");
    }

    @After
    public void after(){
        System.out.println("after....");
    }

}
