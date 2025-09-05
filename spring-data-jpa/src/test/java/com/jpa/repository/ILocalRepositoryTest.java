package com.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.entity.Local;
import com.jpa.entity.Manager;
import com.jpa.entity.Order;

@SpringBootTest
class ILocalRepositoryTest {
	
	@Autowired
	private ILocalRepository localRepository;

	@Test
	public void saveLocal() {
		
		Manager manager = Manager.builder()
				.firstName("Juan")
				.lastName("Chavez")
				.build();
		
		Local local = Local.builder()
				.name("PetShop")
				.floor("Second Floor")
				.manager(manager)
				.build();
		
		localRepository.save(local);
	}
	
	@Test
	public void findAllLocals() {
		List<Local> localList = localRepository.findAll();
		localList.forEach(System.out::println);
	}
	
	@Test
	public void saveLocalWithOrders() {
		
		Manager manager = Manager.builder()
				.firstName("Juana")
				.lastName("Rodriguez")
				.build();
		
		Order order = Order.builder()
				.description("Entrada Pelicula 1 Sala 2 en 2D")
				.price(6.50)
				.build();
		
		Order order2 = Order.builder()
				.description("Entrada Pelicula 2 Sala 3 en 3D")
				.price(8.50)
				.build();
		
		Local local = Local.builder()
				.name("Cinema")
				.floor("Third floor")
				.manager(manager)
				.orderList(List.of(order, order2))
				.build();
		
		localRepository.save(local);
	}
	
	@Test
	public void findAllLocalsWithOrders() {
		List<Local> localList = localRepository.findAll();
		localList.forEach(System.out::println);
	}

}
