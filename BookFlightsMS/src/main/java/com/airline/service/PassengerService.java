package com.airline.service;

import java.util.List;

import com.airline.dto.PassengerDTO;
import com.airline.exception.AirlineServiceException;

public interface PassengerService {
	public void createPassenger(List<PassengerDTO> passengersDTO)throws AirlineServiceException;
}
