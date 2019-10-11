package com.spring.restassignment.dao;

import java.util.List;

import com.spring.restassignment.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();
	
	public Employee getEmployee(int employeeId);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(int employeeId);
	
	
}
