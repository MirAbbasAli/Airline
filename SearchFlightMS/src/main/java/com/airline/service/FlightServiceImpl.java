package com.airline.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.adapter.FlightAdapter;
import com.airline.dto.SearchFlights;
import com.airline.entity.Flight;
import com.airline.exception.AirlineServiceException;
import com.airline.repository.FlightsRepository;

@Service(value="flightService")
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightsRepository flightRepository;
	
	@Override
	public List<String> getSources() throws AirlineServiceException {
		List<String> sources=flightRepository.findFlightSources();
		if(sources==null)
			throw new AirlineServiceException("No details available");
		else 
			return sources;
	}

	@Override
	public List<String> getDestinations() throws AirlineServiceException {
		List<String> destinations=flightRepository.findFlightDestinations();
		if(destinations==null)
			throw new AirlineServiceException("No details available");
		else
			return destinations;
	}

	@Override
	public List<SearchFlights> getFlights(String source, String destination, Date journeyDate)
			throws AirlineServiceException {
		List<Flight> flights = flightRepository.findFlightDetails(source, destination, journeyDate);

		List<SearchFlights> availableFlights = new ArrayList<SearchFlights>();
		for (Flight f : flights) {
			SearchFlights flight = new SearchFlights();
			flight.setFlightId(f.getFlightId());
			flight.setSource(f.getSource());
			flight.setDestination(f.getDestination());
			flight.setJourneyDate(f.getFlightAvailableDate());
			flight.setDepartureTime(f.getDepartureTime());
			flight.setArrivalTime(f.getArrivalTime());
			flight.setSeatCount(f.getSeatCount());
			flight.setAirlines(f.getAirlines());
			flight.setFare(f.getFare());
			availableFlights.add(flight);
		}

		return availableFlights;
	}

	@Override
	public void updateFlight(String flightId, int noOfSeats) throws AirlineServiceException {
		Flight flight = flightRepository.findById(flightId).get();

		if (flight == null) {
			throw new AirlineServiceException("No flight for the given details");
		} else {

			int count = flight.getSeatCount() - Integer.valueOf(noOfSeats);
			flight.setSeatCount(count);
			flightRepository.saveAndFlush(flight);

		}

	}

	@Override
	public SearchFlights getFlights(String flightId) {
		FlightAdapter adapter=new FlightAdapter();
		Flight flight=flightRepository.findById(flightId).get();
		return adapter.toDTO(flight);
	}

}
