package com.spring.restassignment.service;

import java.util.List;

import com.spring.restassignment.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();
	
	public Employee getEmployee(int employeeId);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(int employeeId);
	
}
