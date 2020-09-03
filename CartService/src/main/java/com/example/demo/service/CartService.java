package com.example.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepo;


@Service
public class CartService {

	@Autowired
	private CartRepo repo;

	public List<Cart> getAll() {
		return repo.findAll();
	}

	public Cart findById(int CartId) {
		return repo.findById(CartId).get();
	}

	public String deleteById(int CustId) {
		repo.deleteById(CustId);
		return "deleted";
	}

	public String deleteAll() {
		repo.deleteAll();
		return "All records are deleted";
	}

	public Cart createOrUpdateById(Cart Acc) throws ResourceNotFoundException {		
		
			repo.save(Acc);
			return Acc;	

	}

	public Cart update(Cart cart, int cartId) {
		// int id=Acc.getCustId();
		Cart cartObj = repo.findById(cartId).get();
		cartObj.setCartAmount(cart.getCartAmount());
		cartObj.setQuantity(cart.getQuantity());
		return repo.save(cartObj);
	}

}
