package com.spring.restassignment.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restassignment.entity.Employee;
import com.spring.restassignment.exception.EmployeeNotFoundException;
import com.spring.restassignment.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Student Entity!!!!")
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;

	@ApiOperation(value = "Get list of Employee Details in the System ", response = Iterable.class, tags = "getEmployees")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping(value = "/employees", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Employee> getEmployees() {

		List<Employee> employeeList = employeeService.getEmployees();

		Resources<Employee> resource = new Resources<Employee>(employeeList);
		Link withSelfRel = ControllerLinkBuilder.linkTo(EmployeeRestController.class).slash("/employees").withSelfRel();
		resource.add(withSelfRel);

		return employeeList;
	}

	@ApiOperation(value = "Get specific Employee in the System ", response = Employee.class, tags = "getEmployee")
	@GetMapping(value = "/employees/{employeeId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Employee getEmployee(@PathVariable int employeeId ) {

		Employee employee = employeeService.getEmployee(employeeId);

		if (employee == null) {
			throw new EmployeeNotFoundException("Employee Id: " + employeeId + " is not found");
		}

		Resource<Employee> resource = new Resource<Employee>(employee);
		Link withSelfRel = ControllerLinkBuilder.linkTo(EmployeeRestController.class).slash("/employees").withSelfRel();
		resource.add(withSelfRel);

		return employee;
	}

	@ApiOperation(value = "Post specific Employee details in the System ", response = Employee.class, tags = "postStudent")
	@PostMapping(value = "/employees", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Employee addEmployee(@RequestBody Employee employee) {

		employee.setId(0);
		
		employeeService.saveEmployee(employee);
			return employee;
	}
	@ApiOperation(value = "Put specific Employee details in the System ", response = Employee.class, tags = "putStudent")
	@PutMapping(value = "/employees", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void updateEmployee(@RequestBody Employee employee) {

		employeeService.saveEmployee(employee);
		
		Resource<Employee> resource = new Resource<Employee>(employee);
		Link withSelfRel = ControllerLinkBuilder.linkTo(EmployeeRestController.class).slash("/employees").withSelfRel();
		resource.add(withSelfRel);
	}

	@ApiOperation(value = "Delete specific Employee Details in the System ", response = Employee.class, tags = "deleteStudent")
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {

		Employee employee = employeeService.getEmployee(employeeId);

		if (employee == null) {
			throw new EmployeeNotFoundException(
					"Deletion can't perform because Employee Id: " + employeeId + " is not found");
		}
		Resource<Employee> resource = new Resource<Employee>(employee);
		Link withSelfRel = ControllerLinkBuilder.linkTo(EmployeeRestController.class).slash("/employees").withSelfRel();
		resource.add(withSelfRel);

		employeeService.deleteEmployee(employeeId);

		return "Deleted Employee with ID: " + employeeId;
	}
}
