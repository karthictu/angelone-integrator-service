package com.karthic.angelone_integrator_service.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.karthic.angelone_integrator_service.constants.CommonConstants;
import com.karthic.angelone_integrator_service.handlers.UserHandler;

@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> routes(UserHandler userHandler) {
        return RouterFunctions.nest(RequestPredicates.path(CommonConstants.USERS_API_BASE_URL),
                RouterFunctions.route().GET(userHandler::getUserProfile)
                        .POST(CommonConstants.ENDPOINT_LOGIN, userHandler::loginUser)
                        .POST(CommonConstants.ENDPOINT_TOKEN, userHandler::generateToken)
                        .POST(CommonConstants.ENDPOINT_LOGOUT, userHandler::logoutUser).build());
    }
}
