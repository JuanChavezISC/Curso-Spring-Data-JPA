package com.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Query(
			value = "select *  from tbl_customer where email_address= :emailAddress",
			nativeQuery = true
	)
	Customer getCustomerByEmailAddressNativeNamedParam(@Param("emailAddress") String email);
	
	// Actualizacion de registros en la base de datos
	@Transactional // Crea una transaccion para manejar la modificacion de datos y en caso
	@Modifying // indica una modificacion dentro de la base de datos para mantener la consistencia de los datos 
	@Query(
			value = "update tbl_customer set first_name = ?1 where email_address = ?2",
			nativeQuery= true
	)
	
	void updateCustomerNameByEmail(String name, String email);
	
}
