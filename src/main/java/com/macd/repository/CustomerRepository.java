package com.macd.repository;

import org.springframework.data.repository.CrudRepository;

import com.macd.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
