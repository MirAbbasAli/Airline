package com.airline.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.airline.entity.Flight;

public interface FlightsRepository extends JpaRepository<Flight, String> {
	@Query("select f from Flight f where f.source=:source and f.destination=:dest and f.flightAvailableDate=:jdate")
	public List<Flight> findFlightDetails(@Param("source") String source,@Param("dest") String destination,@Param("jdate") Date date);
	
	@Query("select f from Flight f where f.flightId=:flightId")
	public Flight findFlight(@Param("flightId") String flightId);
	
	@Query("select f.source from Flight f")
	public List<String> findFlightSources();
	
	@Query("select f.destination from Flight f")
	public List<String> findFlightDestinations();
	
	
}
