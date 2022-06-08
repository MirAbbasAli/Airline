package com.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
