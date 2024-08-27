package com.karthic.angelone_integrator_service.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.karthic.angelone_integrator_service.constants.AngelOneConstants;
import com.karthic.angelone_integrator_service.constants.CommonConstants.ProperyConstants;;

@Component
public class WebClientUtils {

    @Value(ProperyConstants.PROPERTY_ANGELONE_API_KEY)
    private String angelOneApiKey;

    public void addHeaders(HttpHeaders httpHeaders, String authToken) {
        httpHeaders.setBearerAuth(authToken);
        httpHeaders.set(AngelOneConstants.HEADER_X_PRIVATE_KEY, angelOneApiKey);
    }
    
}
