package com.cicd.service;

import com.cicd.pojo.Order;
import org.springframework.stereotype.Repository;

@Repository
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
