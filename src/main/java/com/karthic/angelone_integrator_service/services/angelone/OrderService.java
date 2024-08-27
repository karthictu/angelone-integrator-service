package com.karthic.angelone_integrator_service.services.angelone;

import com.karthic.angelone_integrator_service.models.angelone.requests.CancelOrderRequest;
import com.karthic.angelone_integrator_service.models.angelone.requests.CreateOrderRequest;
import com.karthic.angelone_integrator_service.models.angelone.requests.LtpRequest;
import com.karthic.angelone_integrator_service.models.angelone.requests.ModifyOrderRequest;
import com.karthic.angelone_integrator_service.models.angelone.responses.ApiResponse;
import com.karthic.angelone_integrator_service.models.angelone.responses.LtpResponseData;
import com.karthic.angelone_integrator_service.models.angelone.responses.OrderDetailsResponseData;
import com.karthic.angelone_integrator_service.models.angelone.responses.OrderResponseData;

public interface OrderService {
    ApiResponse<OrderResponseData> createOrder(String authToken, CreateOrderRequest createOrderRequest);

    ApiResponse<OrderResponseData> modifyOrder(String authToken, ModifyOrderRequest modifyOrderRequest);

    ApiResponse<OrderResponseData> cancelOrder(String authToken, CancelOrderRequest cancelOrderRequest);

    ApiResponse<LtpResponseData> getLtpData(String authToken, LtpRequest ltpRequest);

    ApiResponse<OrderDetailsResponseData> getOrderDetailsByUniqueOrderId(String authToken, String uniqueOrderId);
}
