package com.github.eminsit.ReadingIsGood.services;

import com.github.eminsit.ReadingIsGood.models.OrderItem;
import com.github.eminsit.ReadingIsGood.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository repo;

    @Override
    public List<OrderItem> getSome(Long orderId) {
        return repo.findAllByOrderId(orderId);
    }

    @Override
    public void save(OrderItem orderItem) {
        repo.save(orderItem);
    }

    @Override
    public void saveAll(List<OrderItem> orderItems) {
        repo.saveAll(orderItems);
    }
}
