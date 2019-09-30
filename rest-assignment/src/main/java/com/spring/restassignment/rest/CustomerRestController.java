package com.spring.restassignment.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;
import java.util.Optional;

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

import com.spring.restassignment.entity.Customer;
import com.spring.restassignment.exception.CustomerNotFoundException;
import com.spring.restassignment.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;

	@GetMapping(value = "/customers", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Resources<Customer> getCustomers() {

		List<Customer> customerList = customerService.getCustomers();

//		Link link = linkTo(CustomerRestController.class).withSelfRel();
//		Resources<Customer> result = new Resources<Customer>(customerList, link);
		
		Resources<Customer> resource = new Resources<Customer>(customerList);
		Link withSelfRel = ControllerLinkBuilder.linkTo(CustomerRestController.class).slash("/customers").withSelfRel();
		resource.add(withSelfRel);

		return resource;
	}

	@GetMapping(value = "/customers/{customerId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Resource<Customer> getCustomer(@PathVariable int customerId ) {

		Customer customer = customerService.getCustomer(customerId);

		if (customer == null) {
			throw new CustomerNotFoundException("Customer Id: " + customerId + " is not found");
		}

		Resource<Customer> resource = new Resource<Customer>(customer);
		Link withSelfRel = ControllerLinkBuilder.linkTo(CustomerRestController.class).slash("/customers").withSelfRel();
		resource.add(withSelfRel);

		return resource;
	}

	@PostMapping(value = "/customers", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Customer addCustomer(@RequestBody Customer customer) {

		customer.setId(0);
		
		Optional<Integer> customerId = Optional.of(customer.getId());
		
		if(!customerId.isPresent()) {
			
			throw new CustomerNotFoundException("Customer(" +customer.getId() + ") is not found in the table");
		}
		customerService.saveCustomer(customer);
		return customer;
	}

	@PutMapping(value = "/customers", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Resource<Customer> updateCustomer(@RequestBody Customer customer) {

		customerService.saveCustomer(customer);
		
		Resource<Customer> resource = new Resource<Customer>(customer);
		Link withSelfRel = ControllerLinkBuilder.linkTo(CustomerRestController.class).slash("/customers").withSelfRel();
		resource.add(withSelfRel);


		return resource;
	}

	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {

		Customer customer = customerService.getCustomer(customerId);

		if (customer == null) {
			throw new CustomerNotFoundException(
					"Deletion can't perform because Customer Id: " + customerId + " is not found");
		}
		Resource<Customer> resource = new Resource<Customer>(customer);
		Link withSelfRel = ControllerLinkBuilder.linkTo(CustomerRestController.class).slash("/customers").withSelfRel();
		resource.add(withSelfRel);

		customerService.deleteCustomer(customerId);

		return "Deleted Customer with ID: " + customerId;
	}
}
