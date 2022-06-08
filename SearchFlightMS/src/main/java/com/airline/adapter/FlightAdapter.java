package com.airline.adapter;

import com.airline.dto.SearchFlights;
import com.airline.entity.Flight;

public class FlightAdapter {
	public SearchFlights toDTO(Flight flight) {
		SearchFlights flightDTO=new SearchFlights();
		flightDTO.setAirlines(flight.getAirlines());
		flightDTO.setArrivalTime(flight.getArrivalTime());
		flightDTO.setDepartureTime(flight.getDepartureTime());
		flightDTO.setDestination(flight.getDestination());
		flightDTO.setFare(flight.getFare());
		flightDTO.setFlightId(flight.getFlightId());
		flightDTO.setJourneyDate(flight.getFlightAvailableDate());
		flightDTO.setSeatCount(flight.getSeatCount());
		flightDTO.setSource(flight.getSource());
		return flightDTO;
	}
}
