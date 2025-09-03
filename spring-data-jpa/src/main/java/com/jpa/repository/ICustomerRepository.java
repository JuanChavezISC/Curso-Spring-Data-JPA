package com.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

	Optional<Customer>  findByFirstName(String firstName);
}
