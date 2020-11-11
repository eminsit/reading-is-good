package com.github.eminsit.ReadingIsGood.services;

import com.github.eminsit.ReadingIsGood.dto.OrderView;
import com.github.eminsit.ReadingIsGood.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    List<Order> getAllByCustomerId(Long customerId);
    Order getOne(Long id);
    Order placeOrder(OrderView orderView);
}
