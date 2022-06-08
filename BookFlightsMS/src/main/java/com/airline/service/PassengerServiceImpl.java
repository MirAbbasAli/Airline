package com.airline.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.adapter.PassengerAdapter;
import com.airline.dto.PassengerDTO;
import com.airline.entity.Passenger;
import com.airline.exception.AirlineServiceException;
import com.airline.repository.PassengerRepository;

@Service(value="passengerService")
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public void createPassenger(List<PassengerDTO> passengersDTO) throws AirlineServiceException {
		List<Passenger> passengers=new ArrayList<>();
		passengersDTO.forEach(passengerDTO->{
			PassengerAdapter adapter=new PassengerAdapter();
			Passenger passenger=adapter.toEntity(passengerDTO);
			passengers.add(passenger);
		});
		passengerRepository.saveAll(passengers);
	}

}
