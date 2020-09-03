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
import com.example.demo.model.Customer;
import com.example.demo.repository.CustAccRepo;
import com.example.demo.service.CustAccService;


@RestController
public class CustAccController {
	
	@Autowired
	private CustAccService service;
	
	@Autowired
	private CustAccRepo Repo;
	
	@GetMapping("/")
	public String home() {
		return "Hello Customer";
	}
	
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getById(@PathVariable (value = "id") int CustId) throws ResourceNotFoundException{
		Customer customer = service.findById(CustId);
		if(customer != null)
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		else
			throw new ResourceNotFoundException("Customer not found");
		
	}
	
	@GetMapping("/getCustomer/{name}")
	public ResponseEntity<Customer> getByName(@PathVariable (value = "name") String CustName) throws ResourceNotFoundException{
		Customer customer = service.findByName(CustName);
		if(customer != null)
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		else
			throw new ResourceNotFoundException("Customer not found");
		
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCust()
	{
		return service.getAll();
	}
	
	@PostMapping("/createCustomer")
	public ResponseEntity<Customer> create(@RequestBody Customer cust) throws ResourceNotFoundException {
		Customer customer = service.createOrUpdateById(cust);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomer/{id}")
	public Customer updateById(@PathVariable (value = "id") int CustId, @RequestBody Customer cust) {
		//Customer 
		return service.update(cust, CustId);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteById(@PathVariable (value = "id") int CustId) {
		service.deleteById(CustId);
		return "deleted";
	}
	
	@DeleteMapping("/deleteAllCustomers")
	public String deleteAll() {
		service.deleteAll();
		return "All records deleted";
	}

}
