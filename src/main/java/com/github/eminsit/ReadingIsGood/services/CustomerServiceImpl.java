package com.github.eminsit.ReadingIsGood.services;

import com.github.eminsit.ReadingIsGood.models.Customer;
import com.github.eminsit.ReadingIsGood.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Override
    public List<Customer> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(Customer customer) {
        repo.save(customer);
    }
}
