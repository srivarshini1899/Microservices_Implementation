package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepo;
import com.example.demo.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService service;
	
	@Autowired
	private CartRepo Repo;
	
	@GetMapping("/")
	public String home() {
		return "Hello Cart";
	}
	
	@GetMapping("/getCart/{id}")
	public ResponseEntity<Cart> getById(@PathVariable (value = "id") int CartId) throws ResourceNotFoundException{
		Cart cart = service.findById(CartId);
		if(cart != null)
			return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		else
			throw new ResourceNotFoundException("Cart not found");
		
	}
	
	@GetMapping("/getAllCarts")
	public List<Cart> getAllCart()
	{
		return service.getAll();
	}
	
	@PostMapping("/createCart")
	public ResponseEntity<Cart> create(@RequestBody Cart cart) throws ResourceNotFoundException {
		Cart cartObj = service.createOrUpdateById(cart);
		return new ResponseEntity<Cart>(cartObj, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCart/{id}")
	public Cart updateById(@PathVariable (value = "id") int CartId, @RequestBody Cart cart) {
		//Customer 
		return service.update(cart, CartId);
	}
	
	@DeleteMapping("/deleteCart/{id}")
	public String deleteById(@PathVariable (value = "id") int CartId) {
		service.deleteById(CartId);
		return "deleted";
	}
	
	@DeleteMapping("/deleteAllCarts")
	public String deleteAll() {
		service.deleteAll();
		return "All records deleted";
	}

}
