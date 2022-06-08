package com.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
