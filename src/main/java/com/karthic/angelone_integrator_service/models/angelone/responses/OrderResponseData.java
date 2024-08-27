package com.karthic.angelone_integrator_service.models.angelone.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class OrderResponseData implements ResponseData {
    private String script;
    private String orderId;
    private String uniqueOrderId;
}
