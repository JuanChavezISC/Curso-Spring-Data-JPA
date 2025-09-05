package com.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.entity.Manager;

@SpringBootTest
class IManagerRepositoryTest {

	@Autowired
	private IManagerRepository managerRepository;
	@Test
	
	public void findAllManager() {
		List<Manager> managerList = managerRepository.findAll();
		System.out.println("managerList = " + managerList);
	}

}
