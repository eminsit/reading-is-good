package com.github.eminsit.ReadingIsGood.controllers;

import com.github.eminsit.ReadingIsGood.dto.OrderView;
import com.github.eminsit.ReadingIsGood.models.Order;
import com.github.eminsit.ReadingIsGood.models.OrderItem;
import com.github.eminsit.ReadingIsGood.services.OrderItemService;
import com.github.eminsit.ReadingIsGood.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/order")
    ResponseEntity<Order> placeOrder(@RequestBody OrderView orderView) {
        return new ResponseEntity<Order>(orderService.placeOrder(orderView), HttpStatus.OK);
    }

    @GetMapping("/orders-of-customer/{customerId}")
    ResponseEntity<List<Order>> getOrders(@PathVariable Long customerId) {
        return new ResponseEntity<List<Order>>(orderService.getAllByCustomerId(customerId), HttpStatus.OK);
    }

    @GetMapping("/order/{orderID}")
    ResponseEntity<Order> getOrder(@PathVariable Long orderID) {
        return new ResponseEntity<>(orderService.getOne(orderID), HttpStatus.OK);
    }
}
