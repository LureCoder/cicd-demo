package com.cicd.controller;

import com.cicd.pojo.Order;
import com.cicd.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cicddemo")
@RequiredArgsConstructor
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    private final OrderService orderService;

    @GetMapping(value="/order/{orderId}")
    public ResponseEntity<Order> queryOrderById(@PathVariable String orderId, @RequestParam("userName") String name){

        logger.info("User name : {}", name);

        Order order = this.orderService.queryOrder(orderId);

        return new ResponseEntity<>(order, HttpStatus.OK);

    }

    /**
     * GET /orders?page=1&size=10
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value="/orders")
    public ResponseEntity<Order> queryOrders(@PathVariable Integer page, @PathVariable Integer size){

        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * Post /order/{orderId}
     * @param orderId
     * @param order
     * @return
     */
    @PostMapping(value="/order/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable String orderId, @RequestBody Order order, @RequestHeader String access_token){

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
