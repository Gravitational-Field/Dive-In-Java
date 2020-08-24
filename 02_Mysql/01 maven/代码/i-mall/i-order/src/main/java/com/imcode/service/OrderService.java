package com.imcode.service;

import com.imcode.dao.OrderDao;
import com.imcode.dao.UserDao;

public class OrderService {

    private OrderDao orderDao = new OrderDao();
    private UserDao userDao = new UserDao();

    public void createOrder(){
        //1.订单信息写入数据库

        orderDao.add();
        //2.给下单用户发送短信（用户手机号）
        //2.1 获取下单用户的手机号
        String mobile = userDao.getUserMobileByUserId(10L);

        //2.2 发送短信
        System.out.println("发送短信成功:" + mobile);
    }
}
