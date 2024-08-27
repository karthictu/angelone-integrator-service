package com.karthic.angelone_integrator_service.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.karthic.angelone_integrator_service.constants.CommonConstants.RouterConstants;
import com.karthic.angelone_integrator_service.handlers.OrderHandler;

@Configuration
public class OrderRouter {

    @Bean
    public RouterFunction<ServerResponse> orderRoutes(OrderHandler orderHandler) {
        return RouterFunctions.nest(RequestPredicates.path(RouterConstants.ORDERS_API_BASE_URL),
                RouterFunctions.route().POST(orderHandler::createOrder)
                        .nest(RequestPredicates.path(RouterConstants.ENDPOINT_ORDER_ID),
                                () -> RouterFunctions.route().GET(orderHandler::getOrder).PUT(orderHandler::modifyOrder)
                                        .DELETE(orderHandler::cancelOrder).build())
                        .build());
    }

}
