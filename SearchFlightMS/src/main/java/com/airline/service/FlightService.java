package com.airline.service;

import java.util.Date;
import java.util.List;

import com.airline.dto.SearchFlights;
import com.airline.exception.AirlineServiceException;

public interface FlightService {
	public List<String> getSources()throws AirlineServiceException;
	
	public List<String> getDestinations()throws AirlineServiceException;
	
	public List<SearchFlights> getFlights(String source, String destination, Date journeyDate)throws AirlineServiceException;
	
	public void updateFlight(String flightId, int noOfSeats)throws AirlineServiceException;
	
	public SearchFlights getFlights(String flightId);
}
