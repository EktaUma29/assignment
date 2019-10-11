package com.spring.restassignment.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.spring.restassignment.RestAssignmentApplication;
import com.spring.restassignment.entity.Employee;
import com.spring.restassignment.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeRestControllerTest {

	private MockMvc mockMvc;

	@Mock
	EmployeeService employeeService;

	@InjectMocks
	EmployeeRestController employeeRestController;


	@Before
	public void setUp() throws RuntimeException {

		this.mockMvc = MockMvcBuilders.standaloneSetup(employeeRestController).setControllerAdvice(new EmployeeErrorExceptionHandler())
				.build();
	}

	@Test
	public void shouldReturnAllEmployeesDetailsInJSON() throws Exception {

		Employee employee1 = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");
		Employee employee2 = new Employee(6, "David", "Adams", "david@luv2code.com");

		ArrayList<Employee> list = new ArrayList<>();
		list.add(employee1);
		list.add(employee2);

		when(employeeService.getEmployees()).thenReturn(list);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/employees").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(5)))
				.andExpect(jsonPath("$[0].firstName", is("Maxwell")))
				.andExpect(jsonPath("$[0].lastName", is("Dixon")))
				.andExpect(jsonPath("$[0].email", is("max@luv2code.com")))
				.andExpect(jsonPath("$[1].id", is(6)))
				.andExpect(jsonPath("$[1].firstName", is("David")))
				.andExpect(jsonPath("$[1].lastName", is("Adams")))
				.andExpect(jsonPath("$[1].email", is("david@luv2code.com")));
		
		verify(employeeService).getEmployees();
	}

	@Test
	public void shouldReturnAllEmployeesDetailsListinXML() throws Exception {
		Employee employee1 = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");
		Employee employee2 = new Employee(6, "David", "Adams", "david@luv2code.com");

		ArrayList<Employee> list = new ArrayList<>();
		list.add(employee1);
		list.add(employee2);

		when(employeeService.getEmployees()).thenReturn(list);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/employees").accept(MediaType.APPLICATION_XML))
				.andExpect(xpath("List/item").nodeCount(2))
				.andExpect(xpath("List/item[1]/id").string(is("5")))
				.andExpect(xpath("List/item[1]/firstName").string(is("Maxwell")))
				.andExpect(xpath("List/item[1]/lastName").string(is("Dixon")))
				.andExpect(xpath("List/item[1]/email").string(is("max@luv2code.com")))
				.andExpect(xpath("List/item[2]/id").string(is("6")))
				.andExpect(xpath("List/item[2]/firstName").string(is("David")))
				.andExpect(xpath("List/item[2]/lastName").string(is("Adams")))
				.andExpect(xpath("List/item[2]/email").string(is("david@luv2code.com")));
		verify(employeeService).getEmployees();
	}

	@Test
	public void ShouldRetutnEmployeeDetailsByIdInJSON() throws Exception {
		Employee employee = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");

		when(employeeService.getEmployee(5)).thenReturn(employee);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/5").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id", is(5)))
				.andExpect(jsonPath("$.firstName", is("Maxwell")))
				.andExpect(jsonPath("$.lastName", is("Dixon")))
				.andExpect(jsonPath("$.email", is("max@luv2code.com")));
			verify(employeeService).getEmployee(5);
	}

	@Test
	public void shouldReturnEmployeeDetailsByIdInXML() throws Exception {
		Employee employee = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");

		when(employeeService.getEmployee(5)).thenReturn(employee);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/5").accept(MediaType.APPLICATION_XML))
				.andExpect(xpath("Employee/id").string(is("5")))
				.andExpect(xpath("Employee/firstName").string(is("Maxwell")))
				.andExpect(xpath("Employee/lastName").string(is("Dixon")))
				.andExpect(xpath("Employee/email").string(is("max@luv2code.com")));
		verify(employeeService).getEmployee(5);
	}
	
	@Test
	public void shouldAddEmployeeDetailsInJSON() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/employees")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{ \"firstName\" : \"Ram\", \"lastName\" : \"Sharma\", \"email\" : \"ram@gmail.com\" }")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id", is(0)))
		.andExpect(jsonPath("$.firstName", is("Ram")))
		.andExpect(jsonPath("$.lastName", is("Sharma")))
		.andExpect(jsonPath("$.email", is("ram@gmail.com")));
		
	}
	
	@Test
	public void shouldPutEmployeeDetailsInJSON() throws Exception {
		Employee employee = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");
		Employee employee1 = new Employee(5, "Ram", "Sharma", "ram@gmail.com");
		doNothing().when(employeeService).saveEmployee(employee);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/api/employees")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{ \"id\" : \"5\", \"firstName\" : \"Ram\", \"lastName\" : \"Sharma\", \"email\" : \"ram@gmail.com\" }")
		.accept(MediaType.APPLICATION_JSON));
		
		verify(employeeService).saveEmployee(employee1);
	}
	
	@Test
	public void shouldDeleteEmployeeDetailsInJSON() throws Exception {
		Employee employee = new Employee(5, "Maxwell", "Dixon", "max@luv2code.com");
		when(employeeService.getEmployee(5)).thenReturn(employee);
		doNothing().when(employeeService).deleteEmployee(5);
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/employees/5").accept(MediaType.APPLICATION_JSON));
		verify(employeeService).getEmployee(5);
		verify(employeeService).deleteEmployee(5);
		
	}
	
	

	@Test
	public void shouldThrowExceptionIfEmployeeDetailsNotAvailableInJSON() throws Exception {

		when(employeeService.getEmployee(10)).thenReturn(null);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/10").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.status", is(404)))
				.andExpect(jsonPath("$.message", is("Employee Id: 10 is not found")));
		
		verify(employeeService).getEmployee(10);
		
	}
	
	@Test
	public void shouldThrowExceptionIfEmployeeIsNotAvailableForDelete() throws Exception {

		when(employeeService.getEmployee(200)).thenReturn(null);
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/employees/200").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.status", is(404)))
				.andExpect(jsonPath("$.message", is("Deletion can't perform because Employee Id: 200 is not found")));
		
		verify(employeeService).getEmployee(200);
		
	}
	
	@Test
	public void shouldThrowExceptionIfEmployeeIdIsStringForm() throws Exception {

		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/aaa").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.status", is(400)))
				.andExpect(jsonPath("$.message", is("Failed to convert value of type 'java.lang.String' to required type 'int'; nested exception is java.lang.NumberFormatException: For input string: \"aaa\"")));
		
		
	}
}
