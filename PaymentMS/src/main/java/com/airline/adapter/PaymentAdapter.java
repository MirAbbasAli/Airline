package com.airline.adapter;

import com.airline.dto.CreditCardDTO;
import com.airline.entity.CreditCard;

public class PaymentAdapter {
	public CreditCardDTO toDTO(CreditCard card) {
		CreditCardDTO cardDTO=new CreditCardDTO();
		cardDTO.setApin(card.getApin());
		cardDTO.setCardHolderName(card.getCardHolderName());
		cardDTO.setCardNumber(card.getCardNumber());
		cardDTO.setCvv(card.getCvv());
		cardDTO.setExpiryMonth(card.getExpiryMonth());
		cardDTO.setExpiryYear(card.getExpiryYear());
		cardDTO.setTotalBill(card.getTotalBill());
		
		return cardDTO;
	}
	
	public CreditCard toEntity(CreditCardDTO cardDTO) {
		CreditCard card=new CreditCard();
		card.setApin(cardDTO.getApin());
		card.setCardHolderName(cardDTO.getCardHolderName());
		card.setCardNumber(cardDTO.getCardNumber());
		card.setCvv(cardDTO.getCvv());
		card.setExpiryMonth(cardDTO.getExpiryMonth());
		card.setExpiryYear(cardDTO.getExpiryYear());
		card.setTotalBill(cardDTO.getTotalBill());
		
		return card;
	}
}
