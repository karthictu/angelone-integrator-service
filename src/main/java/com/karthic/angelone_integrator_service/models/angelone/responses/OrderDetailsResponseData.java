package com.karthic.angelone_integrator_service.models.angelone.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.karthic.angelone_integrator_service.constants.AngelOneConstants.Variety;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class OrderDetailsResponseData implements ResponseData {
    private Variety variety;
    private String orderType;
    private String productType;
    private String price;
    private String triggerPrice;
    private String quantity;
    private String disclosedQuantity;
    private String duration;
    private String squareOff;
    private String stopLoss;
    private String tradingSymbol;
    private String transactionType;
    private String exchange;
    private String symbolToken;
    private String lotSize;
    private String cancelSize;
    private String averagePrice;
    private String orderId;
    private String status;
    private String orderStatus;
    private String updateTime;
    private String orderTag;
    private String uniqueOrderId;
}
