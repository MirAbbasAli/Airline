package com.airline.adapter;

import com.airline.dto.CustomerDTO;
import com.airline.entity.Customer;

public class CustomerAdapter {
	public Customer toEntity(CustomerDTO customerDTO) {
		Customer customer=new Customer();
		customer.setUserId(customerDTO.getUserId());
		customer.setPassword(customerDTO.getPassword());
		customer.setCity(customerDTO.getCity());
		customer.setEmail(customerDTO.getEmail());
		customer.setName(customerDTO.getName());
		customer.setPhone(customerDTO.getPhone());
		
		return customer;
	}
	
	public CustomerDTO toDTO(Customer customer) {
		CustomerDTO customerDTO=new CustomerDTO();
		customerDTO.setCity(customer.getCity());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setName(customer.getName());
		customerDTO.setPassword(customer.getPassword());
		customerDTO.setPhone(customer.getPhone());
		customerDTO.setUserId(customer.getUserId());
		
		return customerDTO;
	}
}
