package com.airline.adapter;

import com.airline.dto.TicketDTO;
import com.airline.entity.Ticket;

public class TicketAdapter {
	public Ticket toEntity(TicketDTO ticketDTO) {
		Ticket ticket=new Ticket();
		ticket.setBookingDate(ticketDTO.getBookingDate());
		ticket.setDepartureDate(ticketDTO.getDepartureDate());
		ticket.setDepartureTime(ticketDTO.getDepartureTime());
		ticket.setFlightId(ticketDTO.getFlightId());
		ticket.setNoOfSeats(ticketDTO.getNoOfSeats());
		ticket.setPnr(ticketDTO.getPnr());
		ticket.setTotalFare(ticketDTO.getTotalFare());
		ticket.setUserId(ticketDTO.getUserId());
		return ticket;
	}
}
