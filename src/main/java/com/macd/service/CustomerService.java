package com.macd.service;

import com.macd.dto.Customer_DTO;
import com.macd.exception.MacDException;

public interface CustomerService {

	Customer_DTO getCustomer(Integer phoneNumber) throws MacDException;

	Integer addCustomer(Customer_DTO customer) throws MacDException;

	void updateCustomer(Integer phoneNumber, String name) throws MacDException;

	void deleteCustomer(Integer phoneNumber) throws MacDException;

}
