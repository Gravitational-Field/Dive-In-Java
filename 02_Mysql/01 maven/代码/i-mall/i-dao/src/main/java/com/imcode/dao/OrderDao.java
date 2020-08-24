package com.imcode.dao;

public class OrderDao {

    public void add(){
        System.out.println("添加订单成功");
    }

    public void deleteById(Long id){
        System.out.println("删除订单成功:" + id);
    }
}
