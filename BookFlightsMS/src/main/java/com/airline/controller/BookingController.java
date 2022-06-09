package com.airline.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	
	@Autowired
	private DiscoveryClient client;
	
	@PostMapping("/{flightId}/{username}")
	public ResponseEntity<BookingDetails> bookFlight(@PathVariable("flightId") String flightId,
			@Valid @RequestBody PassengerDetails passengerDetails,
			@PathVariable("username")String username) throws AirlineServiceException{
		
		List<ServiceInstance> flightInstances=client.getInstances("SearchFlightMS");
		String flightUri=null;
		if(flightInstances!=null && !flightInstances.isEmpty())
			flightUri=flightInstances.get(0).getUri().toString();
		// call get Flight API
		FlightDTO flight=new RestTemplate().getForObject(flightUri+"/flights/"+flightId, FlightDTO.class);
		BookingDetails bookingDetails=bookingService.createBooking(flightId, passengerDetails, username, flight);
		int noOfSeats=bookingDetails.getPassengerList().size();
		new RestTemplate().put(flightUri+"/flights/"+flightId+"/"+noOfSeats, null);
		return new ResponseEntity<>(bookingDetails, HttpStatus.OK);
	}
	
	
}
