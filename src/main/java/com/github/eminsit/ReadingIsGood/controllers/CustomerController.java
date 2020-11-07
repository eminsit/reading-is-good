package com.github.eminsit.ReadingIsGood.controllers;

import com.github.eminsit.ReadingIsGood.models.Customer;
import com.github.eminsit.ReadingIsGood.services.CustomerService;
import com.github.eminsit.ReadingIsGood.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/customer")
    Customer getCustomer() {
        return new Customer(1l, "emin", "emin@emin.com");
    }

    @GetMapping("/customers")
    List<Customer> getCustomers() {
        orderService.getOne();
        return customerService.getAll();
    }

    @GetMapping("/customer-save")
    void save() {
        Customer c = new Customer();
        c.setEmail("email");
        c.setName("Emin");
        customerService.save(c);
    }


}
