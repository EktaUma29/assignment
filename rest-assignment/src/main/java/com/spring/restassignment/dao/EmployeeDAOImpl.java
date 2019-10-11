package com.spring.restassignment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.restassignment.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	public EmployeeDAOImpl() {
		super();
	}

	@Override
	public List<Employee> getEmployees() {
		
		Session currentSeession = entityManager.unwrap(Session.class);
		
		Query query = currentSeession.createQuery("from Employee", Employee.class);
		
		List<Employee> employee = query.getResultList();
		
		return employee;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee = currentSession.get(Employee.class, employeeId);
		
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteEmployee(int employeeId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employeeeObject = currentSession.get(Employee.class, employeeId);
		
		currentSession.delete(employeeeObject);

	}

}
