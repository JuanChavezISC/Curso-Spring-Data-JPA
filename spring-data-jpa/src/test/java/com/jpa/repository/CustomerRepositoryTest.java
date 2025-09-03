package com.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.entity.Customer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class CustomerRepositoryTest {
	
	@Autowired
	
	ICustomerRepository customerRepository;
	
	@Test
	public void safeCustom() {
		Customer customer = Customer.builder()
				.firstName("Fernando")
				.lastName("Suarez")
				.build();
		customerRepository.save(customer);
	}
	
	@Test
	public void findCustomerByFirst() {
		Customer customer = customerRepository.findByFirstName("Fernando").get();
		System.out.println("customer = " + customer);
	}
	
	@Test
	public void findAllCustomers() {
		List<Customer> customerList = customerRepository.findAll();
		System.out.println("customerList = " + customerList);
	}


}
