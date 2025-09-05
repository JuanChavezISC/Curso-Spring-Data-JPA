package com.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.entity.Address;
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
				.firstName("Jhon")
				.lastName("Doe")
				.email("jhonDoe@gmail.com")
				.build();
		customerRepository.save(customer);
	}
	
	@Test
	public void saveCustomerWithAddressEmbedded() {
		Address address = Address.builder()
				.city("Cuenca")
				.mainStreet("Cuenca Av. San Juan de los Pozos")
				.secondaryStreet("Belisario Dominguez")
				.build();
		
		Customer customer = Customer.builder()
				.firstName("Axel")
				.lastName("Sanchez")
				.email("axel@example.com")
				.address(address)
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
		customerList.forEach(System.out::println);
	}

	@Test
	public void findAllCustomersFirstContaining() {
		List<Customer> customerList = customerRepository.findByFirstNameContaining("An");
		customerList.forEach(System.out::println);
	}
	
	@Test
	public void findAllCustomersLastNameNotNull() {
		List<Customer> customerList = customerRepository.findByLastNameNotNull();
		customerList.forEach(System.out::println);
	}
	
	@Test
	public void findAllCustomersByAddressCity() {
		List<Customer> customerList = customerRepository.findByAddress_City("Cuenca");
		customerList.forEach(System.out::println);
	}
	
	@Test
	public void getCustomerByEmailAddress() {
		Customer customer = customerRepository.getCustomerByEmailAddress("alego@example.com");
		System.out.println("customer = " + customer);
		
	}
	
	@Test
	public void getCustomerFirstNameByEmailAddress() {
		String firstName= customerRepository.getCustomerFirstNameByEmailAddress("ana.gomez@example.com");
		System.out.println("customer = " + firstName);
		
	}

	@Test
	public void getCustomerByEmailAddressNative() {
		Customer customer = customerRepository.getCustomerByEmailAddressNative("axel@example.com");
		System.out.println("customer = " + customer);
	}
	
	@Test
	public void getCustomerByEmailAddressNativeNamedParam() {
		Customer customer = customerRepository.getCustomerByEmailAddressNativeNamedParam("maria.lopez@example.com");
		System.out.println("customer = " + customer);
	}
}
