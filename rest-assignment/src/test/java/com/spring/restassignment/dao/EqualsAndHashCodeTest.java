package com.spring.restassignment.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.mysql.cj.protocol.Warning;
import com.spring.restassignment.entity.Employee;

import nl.jqno.equalsverifier.EqualsVerifier;

@RunWith(MockitoJUnitRunner.class)
public class EqualsAndHashCodeTest {

	@InjectMocks
	private Employee employee = new Employee();

	@Test
	public void testEmployeeToString() {
		Employee employee1 = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");
		Employee employee2 = new Employee(6, "David", "Adams", "david@luv2code.com");
		String str = employee1.toString();
		assertEquals(employee1.toString(), str);
	}

	@Test
	public void testEmployeeEqualsAndHashcode() {
		Employee employee1 = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");
		Employee employee2 = new Employee(6, "David", "Adams", "david@luv2code.com");
		employee1.equals(employee2);
		employee1.hashCode();

		EqualsVerifier.forExamples(employee1, employee2).suppress().usingGetClass().verify();

	}

}
