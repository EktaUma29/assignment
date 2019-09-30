package com.spring.restassignment.service;

import java.util.List;

import com.spring.restassignment.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(int customerId);
	
	public void saveCustomer(Customer customer);
	
	public void deleteCustomer(int customerId);
	
}
