package com.example.demo.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Cart;
import com.example.demo.service.CartService;

public class ResourceNotFoundException extends Exception {

	@Autowired
	private CartService service;

	public ResourceNotFoundException() {
		// TODO
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	@GetMapping("/customer/{id}")
	public Cart getCart(@PathVariable int cartId) throws ResourceNotFoundException {
		Cart cart = service.findById(cartId);
		if (cart == null)
			throw new ResourceNotFoundException("Cart not found");
		else
			return cart;
	}
}
