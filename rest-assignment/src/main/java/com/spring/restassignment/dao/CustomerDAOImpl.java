package com.spring.restassignment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.restassignment.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private EntityManager entityManager;

	public CustomerDAOImpl() {
		super();
	}

	@Override
	public List<Customer> getCustomers() {
		
		Session currentSeession = entityManager.unwrap(Session.class);
		
		Query query = currentSeession.createQuery("from Customer", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public Customer getCustomer(int customerId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Customer customer = currentSession.get(Customer.class, customerId);
		
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public void deleteCustomer(int customerId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Customer customerObject = currentSession.get(Customer.class, customerId);
		
		currentSession.delete(customerObject);

	}

}
