package com.lzj.service;


import com.lzj.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
