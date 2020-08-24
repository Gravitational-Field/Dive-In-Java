package com.imcode.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        OrderService orderService = new OrderService();
        orderService.createOrder();

    }
}