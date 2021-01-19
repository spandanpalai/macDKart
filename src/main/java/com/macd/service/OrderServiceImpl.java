package com.macd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.macd.dto.Menu;
import com.macd.dto.Order_DTO;
import com.macd.entity.Order;
import com.macd.exception.MacDException;
import com.macd.repository.OrderRepository;


@Service(value = "orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Integer addOrder(Order_DTO order) throws MacDException{
		if(order.getOrderID()!=null){
			Optional<Order> optional = orderRepository.findById(order.getOrderID());
		if(optional.isPresent()) {
			throw new MacDException("Service.ORDER_EXIST_IN_DB");
		}}
		Order order1 = new Order();
		order1.setOrderList(order.getOrderList());
		Order order2=orderRepository.save(order1);
		return order2.getOrderID();
	}
	
	@Override
	public Order_DTO getOrder(Integer order_id) throws MacDException{
		Optional<Order> optional = orderRepository.findById(order_id);
		Order order = optional.orElseThrow(()-> new MacDException("Service.ORDER_NOT_FOUND"));
		Order_DTO orderDto = new Order_DTO();
		orderDto.setOrderID(order.getOrderID());
		orderDto.setOrderList(order.getOrderList());
		return orderDto;
	}

	@Override
	public void updateOrder(Integer orderId, Menu orderList) throws MacDException{
		Optional<Order> optional = orderRepository.findById(orderId);
		Order order = optional.orElseThrow(()-> new MacDException("Service.ORDER_NOT_FOUND"));
		order.setOrderList(orderList);
	}

	@Override
	public void deleteOrder(Integer orderId) throws MacDException{
		Optional<Order> optional = orderRepository.findById(orderId);
		Order order = optional.orElseThrow(()-> new MacDException("Service.ORDER_NOT_FOUND"));
		orderRepository.delete(order);
	}
}
