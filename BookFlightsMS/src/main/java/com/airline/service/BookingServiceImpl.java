package com.airline.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.airline.dto.BookingDetails;
import com.airline.dto.FlightDTO;
import com.airline.dto.PassengerDTO;
import com.airline.dto.PassengerDetails;
import com.airline.dto.TicketDTO;
import com.airline.exception.AirlineServiceException;

@Service(value="bookingService")
public class BookingServiceImpl implements BookingService {
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private PassengerService passengerService;
	
	@Override
	public BookingDetails createBooking(String flightId, PassengerDetails passengerDetails, String username, FlightDTO flight)
			throws AirlineServiceException {
		if(passengerDetails.getPassengerList().isEmpty())
			throw new AirlineServiceException("Passenger List is empty");
		List<PassengerDTO> passengerList=new ArrayList<PassengerDTO>();
		for(PassengerDTO passengers: passengerDetails.getPassengerList()){
			passengerList.add(passengers);
		}
		TicketDTO ticket=new TicketDTO();
		int noOfSeats;
		int pnr = (int) (Math.random() * 1858955);
		ticket.setPnr(pnr);
		
		double fare=flight.getFare();
		double totalFare=fare*(passengerDetails.getPassengerList().size());
		
		BookingDetails bookingDetails=new BookingDetails();
		bookingDetails.setPassengerList(passengerDetails.getPassengerList());
		bookingDetails.setPnr(pnr);
		bookingDetails.setTotalFare(totalFare);
		
		ticket.setBookingDate(new Date());
		System.out.println(ticket.getBookingDate());
		ticket.setDepartureDate(flight.getJourneyDate());
		ticket.setDepartureTime(flight.getDepartureTime());
		ticket.setFlightId(flight.getFlightId());
		ticket.setUserId(username);		
		ticket.setTotalFare(totalFare);
		noOfSeats = passengerDetails.getPassengerList().size();
		ticket.setNoOfSeats(noOfSeats);
		
	    ticketService.createTicket(ticket);
	    
	    for (PassengerDTO passenger : bookingDetails.getPassengerList()) {
			passenger.setTicket(ticket);	    

		}
		passengerService.createPassenger(bookingDetails.getPassengerList());
		
	    return bookingDetails;
	}

	
	
}
