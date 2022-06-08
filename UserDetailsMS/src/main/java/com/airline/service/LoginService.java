package com.airline.service;

import com.airline.dto.LoginDTO;
import com.airline.exception.AirlineServiceException;

public interface LoginService {
	public boolean isUserValid(LoginDTO customerLogin)throws AirlineServiceException;
}
