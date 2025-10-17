package com.scb.service.impl;

import com.scb.pojo.Order;
import com.scb.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order queryOrder(String orderId) {

        Order order = new Order();
        order.setOrderId(orderId);
        order.setCustomerNumber("123456789");

        return order;
    }
}
