package com.airline.adapter;

import com.airline.dto.PassengerDTO;
import com.airline.entity.Passenger;
import com.airline.entity.Ticket;

public class PassengerAdapter {
	public Passenger toEntity(PassengerDTO passengerDTO) {
		Passenger passenger=new Passenger();
		passenger.setPassengerAge(passengerDTO.getPassengerAge());
		passenger.setPassengerGender(passengerDTO.getPassengerGender());
		passenger.setPassengerName(passengerDTO.getPassengerName());
		TicketAdapter adapter=new TicketAdapter();
		Ticket ticket=adapter.toEntity(passengerDTO.getTicket());
		passenger.setTicket(ticket);
		return passenger;
	}
}
