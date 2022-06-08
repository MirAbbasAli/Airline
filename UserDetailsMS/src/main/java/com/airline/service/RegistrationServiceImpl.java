package com.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.adapter.CustomerAdapter;
import com.airline.dto.CustomerDTO;
import com.airline.entity.Customer;
import com.airline.exception.AirlineServiceException;
import com.airline.repository.CustomerRepository;

@Service(value="registrationService")
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Boolean registerCustomer(CustomerDTO customerDTO) throws AirlineServiceException {
		CustomerAdapter customerAdapter=new CustomerAdapter();
		Customer customer=customerAdapter.toEntity(customerDTO);
		Customer cust=customerRepository.saveAndFlush(customer);
		if(cust==null)
			throw new AirlineServiceException("User record not found");
		return true;
	}

}
