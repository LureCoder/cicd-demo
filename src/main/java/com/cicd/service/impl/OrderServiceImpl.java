package com.cicd.service.impl;

import com.cicd.pojo.Order;
import com.cicd.service.OrderService;
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
