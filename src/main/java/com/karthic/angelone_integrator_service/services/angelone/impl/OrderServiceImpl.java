package com.karthic.angelone_integrator_service.services.angelone.impl;

import static com.karthic.angelone_integrator_service.constants.CommonConstants.ANGELONE_WEB_CLIENT;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.karthic.angelone_integrator_service.constants.CommonConstants.ProperyConstants;
import com.karthic.angelone_integrator_service.entities.Order;
import com.karthic.angelone_integrator_service.models.angelone.requests.CancelOrderRequest;
import com.karthic.angelone_integrator_service.models.angelone.requests.CreateOrderRequest;
import com.karthic.angelone_integrator_service.models.angelone.requests.LtpRequest;
import com.karthic.angelone_integrator_service.models.angelone.requests.ModifyOrderRequest;
import com.karthic.angelone_integrator_service.models.angelone.requests.OrderRequest;
import com.karthic.angelone_integrator_service.models.angelone.responses.ApiResponse;
import com.karthic.angelone_integrator_service.models.angelone.responses.LtpResponseData;
import com.karthic.angelone_integrator_service.models.angelone.responses.OrderDetailsResponseData;
import com.karthic.angelone_integrator_service.models.angelone.responses.OrderResponseData;
import com.karthic.angelone_integrator_service.services.angelone.OrderService;
import com.karthic.angelone_integrator_service.services.database.OrderDbService;
import com.karthic.angelone_integrator_service.utils.OrderUtils;
import com.karthic.angelone_integrator_service.utils.TriFunction;
import com.karthic.angelone_integrator_service.utils.WebClientUtils;

@Service
public class OrderServiceImpl implements OrderService {

    @Value(ProperyConstants.PROPERTY_ENDPOINTS_PLACE_ORDER)
    private String placeOrderEndpoint;

    @Value(ProperyConstants.PROPERTY_ENDPOINTS_MODIFY_ORDER)
    private String modifyOrderEndpoint;

    @Value(ProperyConstants.PROPERTY_ENDPOINTS_CANCEL_ORDER)
    private String cancelOrderEndpoint;

    @Value(ProperyConstants.PROPERTY_ENDPOINTS_GET_LTP)
    private String getLtpEndpoint;

    @Value(ProperyConstants.PROPERTY_ENDPOINTS_ORDER_DETAILS)
    private String orderDetailsEndpoint;

    @Autowired
    @Qualifier(value = ANGELONE_WEB_CLIENT)
    private WebClient webClient;

    @Autowired
    private OrderDbService orderDbService;

    @Autowired
    private WebClientUtils webClientUtils;

    @Autowired
    private OrderUtils orderUtils;

    private BiConsumer<HttpHeaders, String> addHeaders = (headers, authToken) -> webClientUtils.addHeaders(headers,
            authToken);

    private Function<String, Order> findOrderInDb = (orderId) -> orderDbService.getOrderByOrderId(orderId);

    private Function<ApiResponse<OrderResponseData>, Order> constructDbOrderFromResponse = (
            apiResponse) -> orderUtils
                    .constructDbOrderFromResponse(
                            findOrderInDb.apply(apiResponse.getData().getOrderId()),
                            apiResponse);

    private Consumer<ApiResponse<OrderResponseData>> saveToDb = (
            orderResponse) -> orderDbService.saveOrder(constructDbOrderFromResponse.apply(orderResponse));

    private TriFunction<String, String, OrderRequest, ApiResponse<OrderResponseData>> orderPostEndpoints = (
            apiEndpoint, authToken, orderRequest) -> webClient.method(HttpMethod.POST).uri(apiEndpoint)
                    .bodyValue(orderRequest)
                    .headers(headers -> addHeaders.accept(headers, authToken)).retrieve()
                    .bodyToMono(new ParameterizedTypeReference<ApiResponse<OrderResponseData>>() {
                    }).doOnSuccess(saveToDb).block();

    @Override
    @Transactional
    public ApiResponse<OrderResponseData> createOrder(String authToken, CreateOrderRequest createOrderRequest) {
        return orderPostEndpoints.apply(placeOrderEndpoint, authToken, createOrderRequest);
    }

    @Override
    @Transactional
    public ApiResponse<OrderResponseData> modifyOrder(String authToken, ModifyOrderRequest modifyOrderRequest) {
        return orderPostEndpoints.apply(modifyOrderEndpoint, authToken, modifyOrderRequest);
    }

    @Override
    @Transactional
    public ApiResponse<OrderResponseData> cancelOrder(String authToken, CancelOrderRequest cancelOrderRequest) {
        return orderPostEndpoints.apply(cancelOrderEndpoint, authToken, cancelOrderRequest);
    }

    @Override
    public ApiResponse<LtpResponseData> getLtpData(String authToken, LtpRequest ltpRequest) {
        return webClient.method(HttpMethod.POST).uri(getLtpEndpoint)
                .bodyValue(ltpRequest)
                .headers(headers -> addHeaders.accept(headers, authToken)).retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<LtpResponseData>>() {
                }).block();
    }

    @Override
    public ApiResponse<OrderDetailsResponseData> getOrderDetailsByUniqueOrderId(String authToken,
            String uniqueOrderId) {
        return webClient.method(HttpMethod.GET).uri(orderDetailsEndpoint, uniqueOrderId)
                .headers(headers -> addHeaders.accept(headers, authToken)).retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<OrderDetailsResponseData>>() {
                }).block();
    }
}
