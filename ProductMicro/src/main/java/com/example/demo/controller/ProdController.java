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
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import com.example.demo.service.ProductService;


@RestController
public class ProdController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductRepo Repo;
	
	@GetMapping("/")
	public String home() {
		return "Hello Product";
	}
	
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Product> getById(@PathVariable (value = "id") int prodId) throws ResourceNotFoundException{
		Product prod = service.findById(prodId);
		if(prod != null)
			return new ResponseEntity<Product>(prod, HttpStatus.OK);
		else
			throw new ResourceNotFoundException("Product not found");
		
	}
	
	@GetMapping("/getProduct/{name}")
	public ResponseEntity<Product> getByName(@PathVariable (value = "name") String prodName) throws ResourceNotFoundException{
		Product prod = service.findByName(prodName);
		if(prod != null)
			return new ResponseEntity<Product>(prod, HttpStatus.OK);
		else
			throw new ResourceNotFoundException("Product not found");
		
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProd()
	{
		return service.getAll();
	}
	
	@PostMapping("/createProduct")
	public ResponseEntity<Product> create(@RequestBody Product prod) throws ResourceNotFoundException {
		Product product = service.createOrUpdateById(prod);
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateProduct/{id}")
	public Product updateById(@PathVariable (value = "id") int prodId, @RequestBody Product prod) {
		//Customer 
		return service.update(prod, prodId);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteById(@PathVariable (value = "id") int prodId) {
		service.deleteById(prodId);
		return "deleted";
	}
	
	@DeleteMapping("/deleteAllProducts")
	public String deleteAll() {
		service.deleteAll();
		return "All records deleted";
	}

}
