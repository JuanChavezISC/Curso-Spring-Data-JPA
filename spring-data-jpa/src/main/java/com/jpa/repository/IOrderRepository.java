package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long>{

}
