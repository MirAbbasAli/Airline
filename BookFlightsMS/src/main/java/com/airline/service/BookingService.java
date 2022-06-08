package com.airline.service;

import com.airline.dto.BookingDetails;
import com.airline.dto.FlightDTO;
import com.airline.dto.PassengerDetails;
import com.airline.exception.AirlineServiceException;

public interface BookingService {
	public BookingDetails createBooking(String flightId, PassengerDetails passengerDetails, String username, FlightDTO flight) throws AirlineServiceException;
}
