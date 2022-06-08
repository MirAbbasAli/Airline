package com.airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airline.dto.CreditCardDTO;
import com.airline.exception.AirlineServiceException;
import com.airline.service.PaymentService;

@RestController
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping(value="/payment", consumes="application/json")
	public ResponseEntity<Boolean> validateCreditCard(@RequestBody CreditCardDTO cardDTO)throws AirlineServiceException{
		Boolean result=paymentService.validateCreditCard(cardDTO);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/save-card", consumes="application/json")
	public ResponseEntity<Boolean> saveCard(@RequestBody CreditCardDTO cardDTO)throws AirlineServiceException{
		Boolean result=paymentService.saveCreditCard(cardDTO);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
}
