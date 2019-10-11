package com.spring.restassignment.aop;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.spring.restassignment.dao.EmployeeDAO;
import com.spring.restassignment.entity.Employee;
import com.spring.restassignment.exception.EmployeeNotFoundException;
import com.spring.restassignment.service.EmployeeService;
import com.spring.restassignment.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeCRUDAspectTest {

	@Mock
	EmployeeDAO employeeDao;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	
	@Test
	public void shouldReturnLogForServiceClassMethods() {
		Employee employee1 = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");
		
		when(employeeDao.getEmployee(employee1.getId())).thenReturn(employee1);
		
		AspectJProxyFactory aspectJAdvisorFactory = new AspectJProxyFactory(employeeService);
		aspectJAdvisorFactory.addAspect(EmployeeCRUDAspect.class);
		
		EmployeeService proxyService = aspectJAdvisorFactory.getProxy();
		
		proxyService.getEmployee(employee1.getId());
		
	}
	@Test(expected = EmployeeNotFoundException.class)
	public void shouldThrowLogForServiceClassMethods() {
		Employee employee1 = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");
		
		when(employeeDao.getEmployee(employee1.getId())).thenThrow(EmployeeNotFoundException.class);
		
		AspectJProxyFactory aspectJAdvisorFactory = new AspectJProxyFactory(employeeService);
		aspectJAdvisorFactory.addAspect(EmployeeCRUDAspect.class);
		
		EmployeeService proxyService = aspectJAdvisorFactory.getProxy();
		
		
		proxyService.getEmployee(employee1.getId());
		
	}
	
}
