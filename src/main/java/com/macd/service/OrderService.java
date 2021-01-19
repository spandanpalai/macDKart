package com.macd.service;

import com.macd.dto.Menu;
import com.macd.dto.Order_DTO;
import com.macd.exception.MacDException;

public interface OrderService {

	Order_DTO getOrder(Integer order_id) throws MacDException;

	void updateOrder(Integer orderId, Menu orderList) throws MacDException;

	void deleteOrder(Integer orderId) throws MacDException;

	Integer addOrder(Order_DTO order) throws MacDException;

}
