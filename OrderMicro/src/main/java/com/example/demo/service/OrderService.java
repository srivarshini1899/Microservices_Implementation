package com.example.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo repo;

	public List<Order> getAll() {
		return repo.findAll();
	}
	
	public Order findById(int orderId) {
		return repo.findById(orderId).get();
	}

	public String deleteById(int orderId) {
		repo.deleteById(orderId);
		return "deleted";
	}

	public String deleteAll() {
		repo.deleteAll();
		return "All records are deleted";
	}

	public Order createOrUpdateById(Order order) throws ResourceNotFoundException {		
			
			repo.save(order);
			return order;	

	}

	public Order update(Order Acc, int orderId) {
		// int id=Acc.getCustId();
		Order order = repo.findById(orderId).get();
		order.setOrderQuantity(Acc.getOrderQuantity());
		return repo.save(order);
	}

}
