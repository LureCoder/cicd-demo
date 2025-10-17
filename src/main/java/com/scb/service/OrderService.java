package com.scb.service;

import com.scb.pojo.Order;

public interface OrderService {

    Order queryOrder(String orderId);

    default void generateReport(){
        //todo
    }

    static void generateOrderId(){
        //todo
        //
    }
}
