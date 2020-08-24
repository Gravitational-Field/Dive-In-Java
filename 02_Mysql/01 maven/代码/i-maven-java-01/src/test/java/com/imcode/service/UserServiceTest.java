package com.imcode.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
    }

    @Test
    public void sayHello() {

        userService.sayHello();

    }
}