package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Local;

@Repository
public interface ILocalRepository extends JpaRepository<Local, Long> {

}
