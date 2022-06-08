package com.airline.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class PassengerDetails {
	@NotEmpty(message = "Passenger List cannot be empty for booking!")
	List<PassengerDTO> passengerList;
	
	public PassengerDetails() {
		super();
	}

	public List<PassengerDTO> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<PassengerDTO> passengerList) {
		this.passengerList = passengerList;
	}

	@Override
	public String toString() {
		return "PassengerDetails [passengerList=" + passengerList + "]";
	}
	
	
	
}
