package com.macd.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.macd.dto.Customer_DTO;
import com.macd.dto.Order_DTO;
import com.macd.exception.MacDException;
import com.macd.service.CustomerService;
import com.macd.service.OrderService;

@RestController
@RequestMapping(value = "/foodkart")
public class CustomerOrderAPI {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	Environment environment;
	
	@GetMapping(value = "/customer/{phoneNum}")
	public ResponseEntity<Customer_DTO> getCustomer(@PathVariable Integer phoneNum) throws MacDException{
		Customer_DTO customer = customerService.getCustomer(phoneNum);
		return new ResponseEntity<Customer_DTO>(customer,HttpStatus.OK);
	}
	
	@PostMapping(value = "/customer/")
	public ResponseEntity<String> addCustomer(@RequestBody Customer_DTO customer) throws MacDException{
		try {
			Integer custPhone=customerService.addCustomer(customer);
			String success = environment.getProperty("API.CUSTOMER_ADD_SUCCESS") + custPhone;
			return new ResponseEntity<String>(success,HttpStatus.CREATED);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
		
	}
	
	@PutMapping(value = "/customer/{phoneNum}")
	public ResponseEntity<String> updateCustomer(@PathVariable Integer phoneNum, @RequestBody Customer_DTO customer) throws MacDException{
		customerService.updateCustomer(phoneNum, customer.getCustomerName());
		String success = environment.getProperty("API.CUSTOMER_UPDATE_SUCCESS");
		return new ResponseEntity<String>(success,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/customer/{phoneNum}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer phoneNum) throws MacDException{
		customerService.deleteCustomer(phoneNum);
		String success = environment.getProperty("API.CUSTOMER_DELETE_SUCCESS");
		return new ResponseEntity<String>(success,HttpStatus.OK);
	}
	
	@PostMapping(value = "/orders/")
	public ResponseEntity<String> addorder(@RequestBody Order_DTO order) throws MacDException{
		try {
			Integer custPhone=orderService.addOrder(order);
			String success = environment.getProperty("API.ORDER_ADD_SUCCESS");
			return new ResponseEntity<String>(success,HttpStatus.CREATED);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
		
	}
}
