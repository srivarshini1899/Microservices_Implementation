package com.example.demo.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

public class ResourceNotFoundException extends Exception {

	@Autowired
	private ProductService service;

	public ResourceNotFoundException() {
		// TODO
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable int prodId) throws ResourceNotFoundException {
		Product cust = service.findById(prodId);
		if (cust == null)
			throw new ResourceNotFoundException("Customer not found");
		else
			return cust;
	}
}
