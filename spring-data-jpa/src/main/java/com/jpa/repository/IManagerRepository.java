package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Manager;

@Repository
public interface IManagerRepository extends JpaRepository<Manager, Long>{

}
