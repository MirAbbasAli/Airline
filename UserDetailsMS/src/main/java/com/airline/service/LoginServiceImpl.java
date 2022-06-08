package com.airline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.dto.LoginDTO;
import com.airline.entity.Customer;
import com.airline.exception.AirlineServiceException;
import com.airline.repository.CustomerRepository;

@Service(value="loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public boolean isUserValid(LoginDTO customerLogin) throws AirlineServiceException {
		Optional<Customer> optional=customerRepository.findById(customerLogin.getUserId());
		Customer customer=optional.orElseThrow(()-> new AirlineServiceException("User record not found"));
		if(!customer.getPassword().equals(customerLogin.getPassword()))
			throw new AirlineServiceException("Invalid Credentials");
		return true;
	}

}
