package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CustId")
	private int custId;
	@Column(name = "age")
	private int age;
	@Column(name = "state")
	private String state;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "firstName")
	private String firstName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Customer(int custId, int age, String state, String lastName, String firstName) {
		super();
		this.custId = custId;
		this.age = age;
		this.state = state;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public Customer() {

	}

}
