package com.macd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.macd.dto.Customer_DTO;
import com.macd.dto.Order_DTO;
import com.macd.entity.Customer;
import com.macd.entity.Order;
import com.macd.exception.MacDException;
import com.macd.repository.CustomerRepository;
import com.macd.repository.OrderRepository;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Customer_DTO getCustomer(Integer phoneNumber) throws MacDException {
		Optional<Customer> optional = customerRepository.findById(phoneNumber);
		Customer customer = optional.orElseThrow(()-> new MacDException("Service.NO_SUCH_CUSTOMER"));
		Customer_DTO customerDTO = new Customer_DTO();
		customerDTO.setCustomerName(customer.getCustomerName());
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		Order_DTO orderdto;
		Order order = customer.getOrder();
		if(order==null) {
			customerDTO.setOrder(null);
			}
		orderdto = new Order_DTO();
		orderdto.setOrderID(order.getOrderID());
		orderdto.setOrderList(order.getOrderList());
		customerDTO.setOrder(orderdto);
		return customerDTO;
	}
	
	
	@Override
	public Integer addCustomer(Customer_DTO customer1) throws MacDException {
		Optional<Customer> optional = customerRepository.findById(customer1.getPhoneNumber());
		if(optional.isPresent()) {
			throw new MacDException("Service.CUSTOMER_EXIST_IN_DB");
		}
		Customer customer = new Customer();
		customer.setCustomerName(customer1.getCustomerName());
		customer.setPhoneNumber(customer1.getPhoneNumber());
		if(customer1.getOrder()==null) {
			customer.setOrder(null);
		}
		Order order = new Order();
		order.setOrderList(customer1.getOrder().getOrderList());
		//Order order2= orderRepository.save(order);
		customer.setOrder(order);
		
		Customer customer2= customerRepository.save(customer);
		return customer2.getPhoneNumber();
	}
	
	@Override
	public void updateCustomer(Integer phoneNumber,String name) throws MacDException{
		Optional<Customer> optional = customerRepository.findById(phoneNumber);
		Customer customer = optional.orElseThrow(()-> new MacDException("Service.NO_SUCH_CUSTOMER"));
		customer.setCustomerName(name);
	}
	
	@Override
	public void deleteCustomer(Integer phoneNumber) throws MacDException{
		Optional<Customer> optional = customerRepository.findById(phoneNumber);
		Customer customer = optional.orElseThrow(()-> new MacDException("Service.NO_SUCH_CUSTOMER"));
		customerRepository.delete(customer);
	}
}
