package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;


@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	
	@GetMapping("/")
	public String home() {
		return "Hello Order!!!";
	}
	
	@GetMapping("/getOrder/{id}")
	public ResponseEntity<Order> getById(@PathVariable (value = "id") int orderId) throws ResourceNotFoundException{
		Order order = service.findById(orderId);
		if(order != null)
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		else
			throw new ResourceNotFoundException("Order not found");
		
	}
	
	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders()
	{
		return service.getAll();
	}
	
	@PostMapping("/createOrder")
	public ResponseEntity<Order> create(@RequestBody Order ord) throws ResourceNotFoundException {
		Order order = service.createOrUpdateById(ord);
		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public String deleteById(@PathVariable (value = "id") int orderId) {
		service.deleteById(orderId);
		return "deleted";
	}
	
	@DeleteMapping("/deleteAllOrders")
	public String deleteAll() {
		service.deleteAll();
		return "All records deleted";
	}

}
