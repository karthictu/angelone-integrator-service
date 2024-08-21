package com.karthic.angelone_integrator_service.handlers;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public class UserHandler {
    
    public Mono<ServerResponse> loginUser(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> generateToken(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> logoutUser(ServerRequest request) {
        return null;
    }
    
}
