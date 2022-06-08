package com.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, String> {

}
