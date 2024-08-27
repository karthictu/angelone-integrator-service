package com.karthic.angelone_integrator_service.services.database;

import java.util.List;

import com.karthic.angelone_integrator_service.entities.Order;

public interface OrderDbService {
    Order saveOrder(Order order);
    Order getOrderByOrderId(String orderId);
    List<Order> getAllOrdersByUserId(String userId);
}