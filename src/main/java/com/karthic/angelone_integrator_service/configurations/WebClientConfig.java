package com.karthic.angelone_integrator_service.configurations;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.karthic.angelone_integrator_service.constants.CommonConstants;

@Configuration
public class WebClientConfig {

    @Bean(CommonConstants.ANGELONE_WEB_CLIENT)
    public WebClient angelOneWebClient() {
        return WebClient.builder().defaultHeaders(headers -> {
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        }).build();
    }
    
}
