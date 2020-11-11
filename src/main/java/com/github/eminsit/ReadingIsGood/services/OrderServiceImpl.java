package com.github.eminsit.ReadingIsGood.services;

import com.github.eminsit.ReadingIsGood.dto.OrderItemView;
import com.github.eminsit.ReadingIsGood.dto.OrderView;
import com.github.eminsit.ReadingIsGood.exceptions.BookNotFoundException;
import com.github.eminsit.ReadingIsGood.exceptions.CustomerNotFoundException;
import com.github.eminsit.ReadingIsGood.exceptions.OrderNotFoundException;
import com.github.eminsit.ReadingIsGood.exceptions.StockInsufficientException;
import com.github.eminsit.ReadingIsGood.models.Book;
import com.github.eminsit.ReadingIsGood.models.Order;
import com.github.eminsit.ReadingIsGood.models.OrderItem;
import com.github.eminsit.ReadingIsGood.repositories.BookRepository;
import com.github.eminsit.ReadingIsGood.repositories.OrderItemRepository;
import com.github.eminsit.ReadingIsGood.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderItemService orderItemService;



    @Override
    public List<Order> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Order> getAllByCustomerId(Long customerId) {
        return repo.findAllByCustomerId(customerId);
    }

    @Override
    public Order getOne(Long id) {
        var order = Optional.of(repo.findById(id)).orElseThrow(() -> new OrderNotFoundException(id));

        return order.orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    @Transactional(rollbackOn = RuntimeException.class, value = Transactional.TxType.REQUIRES_NEW)
    public Order placeOrder(OrderView orderView) {
        return this.validateOrder(orderView);
    }

    private Order validateOrder(OrderView orderView) {
        var customerId = orderView.getCustomerId();
        var customer = customerService.getOne(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException(customerId);
        }

        Order order = new Order();
        order.setTotalAmount(0.0);
        order.setStatus(1);
        order.setCustomerId(customer.getId());
        var savedOrder = repo.save(order);

        List<Book> updatedBooks = new ArrayList<>();
        List<OrderItem> newOrderItems = new ArrayList<>();
        for (OrderItemView itemView: orderView.getItems()) {
            var book = this.validateBookExists(itemView);
            var orderItem = new OrderItem();
            orderItem.setBook(book);
            orderItem.setBookCount(itemView.getCount());
            orderItem.setOrderId(savedOrder.getId());

            newOrderItems.add(orderItem);
            book.setCount(book.getCount()-itemView.getCount());
            System.out.println(book);
            updatedBooks.add(book);
        }
        orderItemService.saveAll(newOrderItems);
        bookService.saveAll(updatedBooks);

        order.setItems(newOrderItems);
        return order;
    }

    private Book validateBookExists(OrderItemView view) {
        var book = bookService.getOne(view.getBookId());
        if (book == null) {
            throw new CustomerNotFoundException(book.getId());
        } else if(book.getCount() < view.getCount()) {
            throw new StockInsufficientException(book.getId());
        }

        return book;
    }
}
