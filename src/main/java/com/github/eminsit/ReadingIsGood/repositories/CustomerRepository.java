package com.github.eminsit.ReadingIsGood.repositories;

import com.github.eminsit.ReadingIsGood.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findAll();

    Customer findById(long id);
}