package com.github.eminsit.ReadingIsGood.services;

import com.github.eminsit.ReadingIsGood.models.OrderItem;

import java.util.List;

public interface OrderItemService {
    void save(OrderItem orderItem);
    void saveAll(List<OrderItem> books);

    public List<OrderItem> getSome(Long orderId);
}
