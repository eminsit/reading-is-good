package com.github.eminsit.ReadingIsGood.controllers;

import com.github.eminsit.ReadingIsGood.models.Customer;
import com.github.eminsit.ReadingIsGood.services.CustomerService;
import com.github.eminsit.ReadingIsGood.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/customer/{customerId}")
    Customer getCustomer(@RequestParam Long customerId) {
        return new Customer(customerId, "emin", "emin@emin.com");
    }

    @GetMapping("/customers")
    ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/customer")
    ResponseEntity<Customer> save(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }
}
