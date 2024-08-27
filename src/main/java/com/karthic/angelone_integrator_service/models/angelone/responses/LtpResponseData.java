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
public class LtpResponseData implements ResponseData {
    private String tradingSymbol;
    private String symbolToken;
    private String exchange;
    private String open;
    private String high;
    private String low;
    private String close;
    private String ltp;
}
