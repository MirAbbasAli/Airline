package com.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
