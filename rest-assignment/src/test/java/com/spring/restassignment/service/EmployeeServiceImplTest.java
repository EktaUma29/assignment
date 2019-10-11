package com.spring.restassignment.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.restassignment.dao.EmployeeDAO;
import com.spring.restassignment.dao.EmployeeDAOImpl;
import com.spring.restassignment.entity.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTest {

	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;
	
	@Mock
	EmployeeDAOImpl employeeDAO;
	
	
	@Test
	public void shouldReturnALlCustomerDetails() {
		
		Employee customer1 = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");
		Employee customer2 = new Employee(6, "David", "Adams", "david@luv2code.com");

		ArrayList<Employee> list = new ArrayList<>();
		list.add(customer1);
		list.add(customer2);

		when(employeeDAO.getEmployees()).thenReturn(list);
		employeeServiceImpl.getEmployees();
		verify(employeeDAO).getEmployees();
	}
	
	@Test
	public void shouldReturnCustomerDetailsByID() {
		
		Employee customer = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");

		when(employeeDAO.getEmployee(5)).thenReturn(customer);
		employeeServiceImpl.getEmployee(5);
		verify(employeeDAO).getEmployee(5);
	}
	
	@Test
	public void shouldAddCustomerDetails() {
		
		Employee customer = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");

		doNothing().when(employeeDAO).saveEmployee(customer);
		employeeServiceImpl.saveEmployee(customer);
		verify(employeeDAO).saveEmployee(customer);
	}
	
	
	@Test
	public void shouldDeleteCustomerDetailsByID() {
		
		Employee customer = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");

		doNothing().when(employeeDAO).deleteEmployee(5);
		employeeServiceImpl.deleteEmployee(5);
		verify(employeeDAO).deleteEmployee(5);
	}

}
