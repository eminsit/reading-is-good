package com.github.eminsit.ReadingIsGood.repositories;

import com.github.eminsit.ReadingIsGood.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAll();

    List<Order> findAllByCustomerId(Long customerId);

}