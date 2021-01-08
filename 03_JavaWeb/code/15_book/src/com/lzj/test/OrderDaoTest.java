package com.lzj.test;


import com.lzj.dao.OrderDao;
import com.lzj.dao.impl.OrderDaoImpl;
import com.lzj.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDaoTest {

    @Test
    public void saveOrder() {

        OrderDao orderDao = new OrderDaoImpl();

        orderDao.saveOrder(new Order("1234567891",new Date(),new BigDecimal(100),0, 1));

    }
}