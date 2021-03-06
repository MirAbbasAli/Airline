package com.airline.controller;


import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.dto.BookingDetails;
import com.airline.dto.FlightDTO;
import com.airline.dto.PassengerDetails;
import com.airline.exception.AirlineServiceException;
import com.airline.service.BookingService;
import com.airline.service.CircuitBreakerService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/book")
public class BookingController {
	private Log Logger=LogFactory.getLog(this.getClass());
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private CircuitBreakerService circuitBreakerService;
	
	
	@PostMapping("/{flightId}/{username}")
	@CircuitBreaker(name="bookingService", fallbackMethod="bookFlightFallback")
	public ResponseEntity<BookingDetails> bookFlight(@PathVariable("flightId") String flightId,
			@Valid @RequestBody PassengerDetails passengerDetails,
			@PathVariable("username")String username) throws AirlineServiceException{
		// call get Flight API
		FlightDTO flight=circuitBreakerService.getFlights(flightId);
		BookingDetails bookingDetails=bookingService.createBooking(flightId, passengerDetails, username, flight);
		int noOfSeats=bookingDetails.getPassengerList().size();
		circuitBreakerService.updateFlightSeat(flightId, noOfSeats);
		return new ResponseEntity<>(bookingDetails, HttpStatus.OK);
	}
	
	public ResponseEntity<BookingDetails> bookFlightFallback(String flightId, PassengerDetails passengerDetails, String username, Throwable throwable) {
		Logger.info("================= In Fallback =====================");
		return new ResponseEntity<>(new BookingDetails(),HttpStatus.OK);
	}
	
}
