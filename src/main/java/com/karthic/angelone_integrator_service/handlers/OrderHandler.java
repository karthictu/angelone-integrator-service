package com.karthic.angelone_integrator_service.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.karthic.angelone_integrator_service.constants.CommonConstants;
import com.karthic.angelone_integrator_service.models.angelone.requests.CancelOrderRequest;
import com.karthic.angelone_integrator_service.models.angelone.requests.CreateOrderRequest;
import com.karthic.angelone_integrator_service.models.angelone.requests.ModifyOrderRequest;
import com.karthic.angelone_integrator_service.services.angelone.OrderService;

import reactor.core.publisher.Mono;

public class OrderHandler {

    @Autowired
    private OrderService orderService;

    public Mono<ServerResponse> createOrder(ServerRequest request) {
        return ServerResponse.ok().bodyValue(request.bodyToMono(CreateOrderRequest.class).doOnNext(
                data -> orderService.createOrder(request.headers().firstHeader(HttpHeaders.AUTHORIZATION), data)));
    }

    public Mono<ServerResponse> modifyOrder(ServerRequest request) {
        return ServerResponse.ok().bodyValue(request.bodyToMono(ModifyOrderRequest.class).doOnNext(
                data -> orderService.modifyOrder(request.headers().firstHeader(HttpHeaders.AUTHORIZATION), data)));
    }

    public Mono<ServerResponse> cancelOrder(ServerRequest request) {
        return ServerResponse.ok().bodyValue(request.bodyToMono(CancelOrderRequest.class).doOnNext(
                data -> orderService.cancelOrder(request.headers().firstHeader(HttpHeaders.AUTHORIZATION), data)));
    }

    public Mono<ServerResponse> getOrder(ServerRequest request) {
        return ServerResponse.ok()
                .bodyValue(orderService.getOrderDetailsByUniqueOrderId(
                        request.headers().firstHeader(HttpHeaders.AUTHORIZATION),
                        request.pathVariable(CommonConstants.ORDER_ID)));
    }
}
