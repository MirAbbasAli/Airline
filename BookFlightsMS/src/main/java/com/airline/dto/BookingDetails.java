package com.airline.dto;

import java.util.List;

public class BookingDetails {
	private int pnr;
	private double totalFare;
	private List<PassengerDTO> passengerList;
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public List<PassengerDTO> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<PassengerDTO> passengerList) {
		this.passengerList = passengerList;
	}
	
}
