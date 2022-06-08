package com.airline.service;

import com.airline.dto.CreditCardDTO;
import com.airline.exception.AirlineServiceException;

public interface PaymentService {
	public Boolean validateCreditCard(CreditCardDTO creditCardDTO)throws AirlineServiceException;
	public Boolean saveCreditCard(CreditCardDTO creditCardDTO)throws AirlineServiceException;
}
