package com.airline.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.airline.dto.BookingDetails;
import com.airline.dto.FlightDTO;
import com.airline.dto.PassengerDetails;
import com.airline.exception.AirlineServiceException;
import com.airline.service.BookingService;

@RestController
@RequestMapping("/book")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/{flightId}/{username}")
	public ResponseEntity<BookingDetails> bookFlight(@PathVariable("flightId") String flightId,
			@Valid @RequestBody PassengerDetails passengerDetails,
			@PathVariable("username")String username) throws AirlineServiceException{
		
		// call get Flight API
		FlightDTO flight=new RestTemplate().getForObject("http://localhost:9400/flights/"+flightId, FlightDTO.class);
		BookingDetails bookingDetails=bookingService.createBooking(flightId, passengerDetails, username, flight);
		int noOfSeats=bookingDetails.getPassengerList().size();
		new RestTemplate().put("http://localhost:9400/flights/"+flightId+"/"+noOfSeats, null);
		return new ResponseEntity<>(bookingDetails, HttpStatus.OK);
	}
	
	
}
