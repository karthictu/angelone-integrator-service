package com.karthic.angelone_integrator_service.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.karthic.angelone_integrator_service.constants.CommonConstants.RouterConstants;
import com.karthic.angelone_integrator_service.handlers.LtpHandler;

@Configuration
public class LtpRouter {

    @Bean
    public RouterFunction<ServerResponse> ltpRoutes(LtpHandler ltpHandler) {
        return RouterFunctions.route()
                .POST(RequestPredicates.path(RouterConstants.LTP_API_BASE_URL), ltpHandler::getLtpData).build();
    }
}
