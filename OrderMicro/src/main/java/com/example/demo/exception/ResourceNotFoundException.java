package com.example.demo.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

public class ResourceNotFoundException extends Exception {

	@Autowired
	private OrderService service;

	public ResourceNotFoundException() {
		// TODO
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	@GetMapping("/customer/{id}")
	public Order getOrder(@PathVariable int orderId) throws ResourceNotFoundException {
		Order order = service.findById(orderId);
		if (order == null)
			throw new ResourceNotFoundException("Order not found");
		else
			return order;
	}
}
