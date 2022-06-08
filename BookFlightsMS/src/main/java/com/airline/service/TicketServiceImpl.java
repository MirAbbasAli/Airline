package com.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.adapter.TicketAdapter;
import com.airline.dto.TicketDTO;
import com.airline.entity.Ticket;
import com.airline.exception.AirlineServiceException;
import com.airline.repository.TicketRepository;

@Service(value="ticketService")
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public void createTicket(TicketDTO ticketDTO) throws AirlineServiceException {
		TicketAdapter adapter=new TicketAdapter();
		Ticket ticket=adapter.toEntity(ticketDTO);
		ticketRepository.save(ticket);

	}

}
