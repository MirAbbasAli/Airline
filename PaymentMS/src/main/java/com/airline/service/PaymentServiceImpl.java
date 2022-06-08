package com.airline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.adapter.PaymentAdapter;
import com.airline.dto.CreditCardDTO;
import com.airline.entity.CreditCard;
import com.airline.exception.AirlineServiceException;
import com.airline.repository.CreditCardRepository;

@Service(value="paymentService")
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private CreditCardRepository creditCardRepository;
	
	@Override
	public Boolean validateCreditCard(CreditCardDTO creditCardDTO) throws AirlineServiceException {
		Optional<CreditCard> optional=creditCardRepository.findById(creditCardDTO.getCardNumber());
		CreditCard card=optional.orElseThrow(()->new AirlineServiceException("Card Not Found!!"));
		return card.getApin().equals(creditCardDTO.getApin())
				&& card.getCardHolderName().equals(creditCardDTO.getCardHolderName())
				&& card.getCvv().equals(creditCardDTO.getCvv());
	}
	
	@Override
	public Boolean saveCreditCard(CreditCardDTO creditCardDTO)throws AirlineServiceException{
		PaymentAdapter adapter=new PaymentAdapter();
		CreditCard card=adapter.toEntity(creditCardDTO);
		CreditCard c=creditCardRepository.saveAndFlush(card);
		if(c==null)
			throw new AirlineServiceException("Card Not Found!!");
		return true;
		
	}
}
