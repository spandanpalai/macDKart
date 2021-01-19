package com.macd.repository;

import org.springframework.data.repository.CrudRepository;

import com.macd.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
