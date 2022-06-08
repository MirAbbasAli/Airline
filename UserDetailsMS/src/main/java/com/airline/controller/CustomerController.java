package com.airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airline.dto.CustomerDTO;
import com.airline.dto.LoginDTO;
import com.airline.exception.AirlineServiceException;
import com.airline.service.LoginService;
import com.airline.service.RegistrationService;

@RestController
public class CustomerController {
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping(value="/login", consumes="application/json")
	public ResponseEntity<Boolean> loginCustomer(@RequestBody LoginDTO login)throws AirlineServiceException{
		Boolean result=false;
		result=loginService.isUserValid(login);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(value="/register", consumes="application/json")
	public ResponseEntity<Boolean> registerCustomer(@RequestBody CustomerDTO customerDTO)throws AirlineServiceException{
		Boolean result=registrationService.registerCustomer(customerDTO);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
