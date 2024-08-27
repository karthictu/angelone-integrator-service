package com.karthic.angelone_integrator_service.constants;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonConstants {

    public class SymbolConstants {
        protected static final String SYMBOLS_FORWARD_SLASH = "/";
        protected static final String SYMBOLS_DOLLAR = "$";
        protected static final String SYMBOLS_DOT = ".";
        protected static final String SYMBOLS_HYPHEN = "-";
        protected static final String SYMBOLS_OPEN_CURLY = "{";
        protected static final String SYMBOLS_CLOSE_CURLY = "}";
    }

    public static final String API = "api";
    public static final String KEY = "key";
    public static final String ENDPOINTS = "endpoints";
    public static final String API_KEY = API + SymbolConstants.SYMBOLS_HYPHEN + KEY;

    public static final String ANGELONE_WEB_CLIENT = "angelOneWebClient";
    public static final String ANGELONE = "angelone";

    public static final String ORDER = "order";
    public static final String ORDERS = ORDER + "s";
    public static final String ORDER_ID = ORDER + "Id";
    public static final String DETAILS = "details";
    public static final String ORDER_DETAILS = ORDER + SymbolConstants.SYMBOLS_HYPHEN + DETAILS;
    public static final String LAST_TRADED_PRICE = "last-traded-price";

    public static final String PLACE_ORDER = "place" + SymbolConstants.SYMBOLS_HYPHEN + ORDER;
    public static final String MODIFY_ORDER = "modify" + SymbolConstants.SYMBOLS_HYPHEN + ORDER;
    public static final String CANCEL_ORDER = "cancel" + SymbolConstants.SYMBOLS_HYPHEN + ORDER;
    public static final String GET_LTP = "get-ltp";

    public static final String ANGELONE_API_KEY = ANGELONE + SymbolConstants.SYMBOLS_DOT + API_KEY;

    public class RouterConstants {
        public static final String ENDPOINT_API = SymbolConstants.SYMBOLS_FORWARD_SLASH + API;

        public static final String ENDPOINT_ORDERS = SymbolConstants.SYMBOLS_FORWARD_SLASH + ORDERS;
        public static final String ENDPOINT_ORDER_ID = SymbolConstants.SYMBOLS_FORWARD_SLASH + SymbolConstants.SYMBOLS_OPEN_CURLY + ORDER_ID
                + SymbolConstants.SYMBOLS_CLOSE_CURLY;
        public static final String ORDERS_API_BASE_URL = ENDPOINT_API + ENDPOINT_ORDERS;

        public static final String ENDPOINT_LTP = SymbolConstants.SYMBOLS_FORWARD_SLASH + LAST_TRADED_PRICE;
        public static final String LTP_API_BASE_URL = ENDPOINT_API + ENDPOINT_LTP;
    }

    public class ProperyConstants {

        private static final String ANGELONE_ENDPOINTS_PLACE_ORDER = ANGELONE + SymbolConstants.SYMBOLS_DOT + ENDPOINTS + SymbolConstants.SYMBOLS_DOT
                + PLACE_ORDER;
        private static final String ANGELONE_ENDPOINTS_MODIFY_ORDER = ANGELONE + SymbolConstants.SYMBOLS_DOT + ENDPOINTS + SymbolConstants.SYMBOLS_DOT
                + MODIFY_ORDER;
        private static final String ANGELONE_ENDPOINTS_CANCEL_ORDER = ANGELONE + SymbolConstants.SYMBOLS_DOT + ENDPOINTS + SymbolConstants.SYMBOLS_DOT
                + CANCEL_ORDER;
        private static final String ANGELONE_ENDPOINTS_GET_LTP = ANGELONE + SymbolConstants.SYMBOLS_DOT + ENDPOINTS + SymbolConstants.SYMBOLS_DOT
                + GET_LTP;
        private static final String ANGELONE_ENDPOINTS_ORDER_DETAILS = ANGELONE + SymbolConstants.SYMBOLS_DOT + ENDPOINTS + SymbolConstants.SYMBOLS_DOT
                + ORDER_DETAILS;

        public static final String PROPERTY_ANGELONE_API_KEY = SymbolConstants.SYMBOLS_DOLLAR + SymbolConstants.SYMBOLS_OPEN_CURLY + ANGELONE_API_KEY
                + SymbolConstants.SYMBOLS_CLOSE_CURLY;
        public static final String PROPERTY_ENDPOINTS_PLACE_ORDER = SymbolConstants.SYMBOLS_DOLLAR + SymbolConstants.SYMBOLS_OPEN_CURLY
                + ANGELONE_ENDPOINTS_PLACE_ORDER
                + SymbolConstants.SYMBOLS_CLOSE_CURLY;
        public static final String PROPERTY_ENDPOINTS_MODIFY_ORDER = SymbolConstants.SYMBOLS_DOLLAR + SymbolConstants.SYMBOLS_OPEN_CURLY
                + ANGELONE_ENDPOINTS_MODIFY_ORDER
                + SymbolConstants.SYMBOLS_CLOSE_CURLY;
        public static final String PROPERTY_ENDPOINTS_CANCEL_ORDER = SymbolConstants.SYMBOLS_DOLLAR + SymbolConstants.SYMBOLS_OPEN_CURLY
                + ANGELONE_ENDPOINTS_CANCEL_ORDER
                + SymbolConstants.SYMBOLS_CLOSE_CURLY;
        public static final String PROPERTY_ENDPOINTS_GET_LTP = SymbolConstants.SYMBOLS_DOLLAR + SymbolConstants.SYMBOLS_OPEN_CURLY
                + ANGELONE_ENDPOINTS_GET_LTP
                + SymbolConstants.SYMBOLS_CLOSE_CURLY;
        public static final String PROPERTY_ENDPOINTS_ORDER_DETAILS = SymbolConstants.SYMBOLS_DOLLAR + SymbolConstants.SYMBOLS_OPEN_CURLY
                + ANGELONE_ENDPOINTS_ORDER_DETAILS
                + SymbolConstants.SYMBOLS_CLOSE_CURLY;
    }

}
