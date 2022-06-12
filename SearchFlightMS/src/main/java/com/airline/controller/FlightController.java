package com.airline.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.dto.SearchFlights;
import com.airline.exception.AirlineServiceException;
import com.airline.service.FlightService;
import com.airline.utility.MyDateEditor;

@RestController
@RequestMapping("/flights")
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new MyDateEditor(format));
	}
	
	@GetMapping("/{flightId}")
	public SearchFlights getFlights(@PathVariable("flightId") String flightId) throws AirlineServiceException {
		if(flightId.equals("F101"))
			throw new RuntimeException();
		System.out.println("flight id" + flightId);
		return flightService.getFlights(flightId);
	}

	@GetMapping("/sources")
	public List<String> getFlightSources() throws AirlineServiceException {
		System.out.println("In get sources");
		return flightService.getSources();
	}

	@GetMapping("/destinations")
	public List<String> getFlightDestinations() throws AirlineServiceException {
		System.out.println("In get sources");
		return flightService.getDestinations();
	}

	@GetMapping("/{source}/{destination}/{journeyDate}")
	public ResponseEntity<List<SearchFlights>> getFlightDetails(@PathVariable String source,
			HttpServletResponse response, @PathVariable String destination, @PathVariable Date journeyDate) throws AirlineServiceException {
		List<SearchFlights> availableFlights = flightService.getFlights(source, destination, journeyDate);
		return new ResponseEntity<List<SearchFlights>>(availableFlights, HttpStatus.OK);

	}

	@PutMapping(value = "/{flightId}/{noOfSeats}")
	public void updateFlightSeat(@PathVariable String flightId, @PathVariable int noOfSeats)
			throws AirlineServiceException {
		flightService.updateFlight(flightId, noOfSeats);

	}
}
