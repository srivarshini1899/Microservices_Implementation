package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustAccRepo;

@Service
public class CustAccService {

	@Autowired
	private CustAccRepo repo;

	public List<Customer> getAll() {
		return repo.findAll();
	}

	public Customer findByName(String CustName) {
		return repo.findByFirstName(CustName);
	}

	public Customer findById(int CustId) {
		return repo.findById(CustId).get();
	}

	public String deleteById(int CustId) {
		repo.deleteById(CustId);
		return "deleted";
	}

	public String deleteAll() {
		repo.deleteAll();
		return "All records are deleted";
	}

	public Customer createOrUpdateById(Customer Acc) throws ResourceNotFoundException {		
			
			repo.save(Acc);
			return Acc;	

	}

	public Customer update(Customer Acc, int custId) {
		// int id=Acc.getCustId();
		Customer cust = repo.findById(custId).get();
		cust.setFirstName(Acc.getFirstName());
		cust.setLastName(Acc.getLastName());
		cust.setAge(Acc.getAge());
		cust.setState(Acc.getState());
		return repo.save(cust);
	}

}
