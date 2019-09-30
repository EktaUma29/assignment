package com.spring.restassignment.dao;

import java.util.List;

import com.spring.restassignment.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(int customerId);
	
	public void saveCustomer(Customer customer);
	
	public void deleteCustomer(int customerId);
	
	
}
