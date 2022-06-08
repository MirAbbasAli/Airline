package com.airline.service;

import com.airline.dto.CustomerDTO;
import com.airline.exception.AirlineServiceException;

public interface RegistrationService {
	public Boolean registerCustomer(CustomerDTO customerDTO)throws AirlineServiceException;
}
