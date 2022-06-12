package com.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.controller.FlightsFeign;
import com.airline.dto.FlightDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service(value="circuitBreakerService")
public class CircuitBreakerService {
	@Autowired
	private FlightsFeign flightsFeign;
	
	@CircuitBreaker(name="bookingService")
	public FlightDTO getFlights(String flightId){
		return flightsFeign.getFlights(flightId);
	}
	
	@CircuitBreaker(name="bookingService")
	public void updateFlightSeat(String flightId, int noOfSeats) {
		flightsFeign.updateFlightSeat(flightId, noOfSeats);
	}
}
