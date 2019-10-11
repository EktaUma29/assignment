//package com.spring.restassignment.dao;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
//import org.hibernate.Session;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.spring.restassignment.entity.Employee;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//public class EmployeeDAOImplTest {
//	
////	@Autowired
//	EmployeeDAOImpl employeeDAO;
//	
//	@Autowired
//	EntityManager entityManager;
//	
//	@Before
//    public void init() {
////        this.employeeDAO = new EmployeeDAOImpl();
////        entityManager = mock(EntityManager.class);
//
//    }
//	
//	@Test
//	public void shouldReturnListOfEmployees() {
//		
//		Employee employee1 = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");
//		Employee employee2 = new Employee(6, "David", "Adams", "david@luv2code.com");
//
//		ArrayList<Employee> list = new ArrayList<>();
//		list.add(employee1);
//		list.add(employee2);
//		
////		when(employeeDAO.getEmployees()).thenReturn(list);
////		
////		verify(employeeDAO).getEmployees();
////		
////		 Query mockedQuery = mock(Query.class);
////	        when(mockedQuery.getResultList()).thenReturn(results);
////	        when(this.cut.em.createNamedQuery(name)).thenReturn(mockedQuery);
//		
//		Session currentSeession = entityManager.unwrap(Session.class);
//	        Query query = mock(Query.class);
//	        when(query.getResultList()).thenReturn(list);
//	        when(entityManager.unwrap(Session.class)).thenReturn(currentSeession);
//	        when(entityManager.createNamedQuery("from Employee")).thenReturn(query);
//		
//	        when(employeeDAO.getEmployees()).thenReturn(list);
//		
//	        verify(query).getResultList();
//		
//	}
//
//}
