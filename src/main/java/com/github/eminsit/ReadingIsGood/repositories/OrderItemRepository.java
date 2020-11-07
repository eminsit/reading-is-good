package com.github.eminsit.ReadingIsGood.repositories;

import com.github.eminsit.ReadingIsGood.models.Order;
import com.github.eminsit.ReadingIsGood.models.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

    List<OrderItem> findAllByOrderId(Long order);
    List<OrderItem> findAll();

}