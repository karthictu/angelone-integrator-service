package com.karthic.angelone_integrator_service.constants;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AngelOneConstants {

    public static final String HEADER_X_PRIVATE_KEY = "X-PrivateKey";

    public enum Variety {
        NORMAL,
        STOPLOSS,
        AMO,
        ROBO
    }

    public enum TransactionType {
        BUY,
        SELL
    }

    public enum OrderType {
        MARKET,
        LIMIT,
        STOPLOSS_LIMIT,
        STOPLOSS_MARKET
    }

    public enum ProductType {
        DELIVERY,
        BO
    }

    public enum Duration {
        DAY,
        IOC
    }

    public enum Exchange {
        BSE,
        NSE
    }

}
