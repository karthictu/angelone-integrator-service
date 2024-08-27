package com.karthic.angelone_integrator_service.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.karthic.angelone_integrator_service.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {

    List<Order> findAllOrdersByUserId(String userId);
}