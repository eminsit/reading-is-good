package com.github.eminsit.ReadingIsGood.services;

import com.github.eminsit.ReadingIsGood.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order getOne();
}
