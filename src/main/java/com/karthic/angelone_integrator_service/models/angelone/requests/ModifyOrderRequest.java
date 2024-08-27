package com.karthic.angelone_integrator_service.models.angelone.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.karthic.angelone_integrator_service.constants.AngelOneConstants.Duration;
import com.karthic.angelone_integrator_service.constants.AngelOneConstants.Exchange;
import com.karthic.angelone_integrator_service.constants.AngelOneConstants.OrderType;
import com.karthic.angelone_integrator_service.constants.AngelOneConstants.ProductType;
import com.karthic.angelone_integrator_service.constants.AngelOneConstants.Variety;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class ModifyOrderRequest implements OrderRequest {
    private Variety vareity;
    private String orderId;
    private String tradingSymbol;
    private String symbolToken;
    private Exchange exchange;
    private OrderType orderType;
    private ProductType productType;
    private Duration duration;
    private String price;
    private String quantity;
}
