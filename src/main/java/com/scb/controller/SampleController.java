package com.scb.controller;

import com.scb.pojo.Order;
import com.scb.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scb/order")
@RequiredArgsConstructor
public class SampleController {

    private final OrderService orderService;

    @GetMapping(value="/queryOrder/{orderId}")
    public ResponseEntity<Order> queryOrder(@PathVariable String orderId){

        Order order = this.orderService.queryOrder(orderId);

        return new ResponseEntity<>(order, HttpStatus.OK);

    }
}
