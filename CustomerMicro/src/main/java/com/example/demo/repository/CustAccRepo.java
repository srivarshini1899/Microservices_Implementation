package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustAccRepo extends JpaRepository<Customer, Integer>{
	
	Customer findByFirstName(String custName);
	
	

}
