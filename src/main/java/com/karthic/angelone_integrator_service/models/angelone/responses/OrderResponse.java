package com.karthic.angelone_integrator_service.models.angelone.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Boolean status; 
    private String message;
    private String errorcode;
    private OrderResponseData data;
}
