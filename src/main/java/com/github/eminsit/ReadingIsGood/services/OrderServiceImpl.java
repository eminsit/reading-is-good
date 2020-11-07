package com.github.eminsit.ReadingIsGood.services;

import com.github.eminsit.ReadingIsGood.models.Order;
import com.github.eminsit.ReadingIsGood.models.OrderItem;
import com.github.eminsit.ReadingIsGood.repositories.BookRepository;
import com.github.eminsit.ReadingIsGood.repositories.OrderItemRepository;
import com.github.eminsit.ReadingIsGood.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Order> getAll() {
        return repo.findAll();
    }

    @Override
    public Order getOne() {
        Long id = 1l;
        var order = Optional.of(repo.findById(id)).orElse(null);

        var itemx = orderItemRepository.findAllByOrderId(order.get().getId());

//        for (OrderItem item: order.get().getItems()) {
//            bookRepository.findBookById(item.getBookId());
//        }

        return order.orElse(null);
    }
}
