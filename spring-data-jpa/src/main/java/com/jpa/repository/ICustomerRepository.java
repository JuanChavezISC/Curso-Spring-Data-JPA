package com.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

	Optional<Customer>  findByFirstName(String firstName);
	
	List<Customer> findByFirstNameContaining(String firstName);
	
	List<Customer> findByLastNameNotNull();
	
	List<Customer> findByAddress_City(String city);
	
	// Consultas con JPQL
	@Query("select c from Customer c where c.email =?1")
	Customer getCustomerByEmailAddress(String email);
	
	@Query("select c.firstName from Customer c where c.email =?1")
	String getCustomerFirstNameByEmailAddress(String email);
	
	
	// Consulta nativa
	@Query(
			value = "select *  from tbl_customer where email_address=?1",
			nativeQuery = true
	)
	Customer getCustomerByEmailAddressNative(String email);
}
