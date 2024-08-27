package com.karthic.angelone_integrator_service.utils;

import org.springframework.stereotype.Component;

import com.karthic.angelone_integrator_service.entities.Order;
import com.karthic.angelone_integrator_service.models.angelone.responses.ApiResponse;
import com.karthic.angelone_integrator_service.models.angelone.responses.OrderResponseData;

@Component
public class OrderUtils {
    
    public Order constructDbOrderFromResponse(Order exisingOrder, ApiResponse<OrderResponseData> orderResponse) {
        exisingOrder.setUniqueOrderId(orderResponse.getData().getUniqueOrderId());
        return exisingOrder;
    }
}
