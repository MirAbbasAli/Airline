package com.airline.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.airline.dto.FlightDTO;

@FeignClient(name="SearchFlightMS", url="http://localhost:9000/")
public interface FlightsFeign {
	@GetMapping("/flights/{flightId}")
	public FlightDTO getFlights(@PathVariable("flightId") String flightId);
	
	@PutMapping(value = "/flights/{flightId}/{noOfSeats}")
	public void updateFlightSeat(@PathVariable String flightId, @PathVariable int noOfSeats);

}
