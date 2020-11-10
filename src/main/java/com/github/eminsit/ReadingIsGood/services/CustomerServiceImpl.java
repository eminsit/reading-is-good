package com.github.eminsit.ReadingIsGood.services;

import com.github.eminsit.ReadingIsGood.models.Customer;
import com.github.eminsit.ReadingIsGood.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Override
    public List<Customer> getAll() {
        return repo.findAll();
    }

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Override
    public Customer getOne(Long id) {
        logger.info("getOne customerID: ");
        return repo.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return repo.save(customer);
    }
}
