package com.karthic.angelone_integrator_service.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.karthic.angelone_integrator_service.models.angelone.requests.ModifyOrderRequest;
import com.karthic.angelone_integrator_service.services.angelone.OrderService;

import reactor.core.publisher.Mono;

public class LtpHandler {

    @Autowired
    private OrderService orderService;

    public Mono<ServerResponse> getLtpData(ServerRequest request) {
        return ServerResponse.ok().bodyValue(request.bodyToMono(ModifyOrderRequest.class).doOnNext(
                data -> orderService.modifyOrder(request.headers().firstHeader(HttpHeaders.AUTHORIZATION), data)));
    }
}
