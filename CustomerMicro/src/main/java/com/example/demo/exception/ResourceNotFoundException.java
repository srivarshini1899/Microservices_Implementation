package com.example.demo.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Customer;
import com.example.demo.service.CustAccService;

public class ResourceNotFoundException extends Exception {

	@Autowired
	private CustAccService service;

	public ResourceNotFoundException() {
		// TODO
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable int custId) throws ResourceNotFoundException {
		Customer cust = service.findById(custId);
		if (cust == null)
			throw new ResourceNotFoundException("Customer not found");
		else
			return cust;
	}
}
