package com.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.entity.Local;
import com.jpa.entity.Order;

@SpringBootTest
class IOrderRepositoryTest {
	
	@Autowired
	IOrderRepository orderRepository;

	@Test
	public void saveOrder() {
		
		Local local = Local.builder()
				.name("Binco")
				.floor("Fourth floor")
				.build();
		
		Order order = Order.builder()
				.description("Camisa De tirantes blanca")
				.price(10.0)
				.local( local)
				.build();
		
		orderRepository.save(order);
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
