package com.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.entity.Local;
import com.jpa.entity.Manager;

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

}
