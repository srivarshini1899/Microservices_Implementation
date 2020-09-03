package com.example.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;

	public List<Product> getAll() {
		return repo.findAll();
	}

	public Product findByName(String prodName) {
		return repo.findByProdName(prodName);
	}

	public Product findById(int prodId) {
		return repo.findById(prodId).get();
	}

	public String deleteById(int prodId) {
		repo.deleteById(prodId);
		return "deleted";
	}

	public String deleteAll() {
		repo.deleteAll();
		return "All records are deleted";
	}

	public Product createOrUpdateById(Product product) throws ResourceNotFoundException {		
		
			repo.save(product);
			return product;	

	}

	public Product update(Product product, int prodId) {
		// int id=Acc.getCustId();
		Product prod = repo.findById(prodId).get();
		prod.setProdName(product.getProdName());
		prod.setQuantity(product.getQuantity());
		prod.setPrice(product.getPrice());
		return repo.save(prod);
	}

}
