package com.airline.service;

import com.airline.dto.TicketDTO;
import com.airline.exception.AirlineServiceException;

public interface TicketService {
	public void createTicket(TicketDTO ticketDTO)throws AirlineServiceException;
}
