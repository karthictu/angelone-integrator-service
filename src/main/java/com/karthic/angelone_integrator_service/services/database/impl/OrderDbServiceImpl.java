package com.karthic.angelone_integrator_service.services.database.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthic.angelone_integrator_service.entities.Order;
import com.karthic.angelone_integrator_service.repositories.OrderRepository;
import com.karthic.angelone_integrator_service.services.database.OrderDbService;

@Service
public class OrderDbServiceImpl implements OrderDbService {

    @Autowired private OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderByOrderId(String orderId) throws NoSuchElementException {
        return orderRepository.findById(orderId).orElseThrow();
    }

    @Override
    public List<Order> getAllOrdersByUserId(String userId) {
        return orderRepository.findAllOrdersByUserId(userId);
    }
    
}
