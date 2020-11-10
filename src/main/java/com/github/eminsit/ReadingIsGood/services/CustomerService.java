package com.github.eminsit.ReadingIsGood.services;

import com.github.eminsit.ReadingIsGood.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer save(Customer customer);
    Customer getOne(Long id);
}
