package com.karthic.angelone_integrator_service.constants;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonConstants {

    public static final String USERS = "users";
    public static final String USER_ID = "userId";
    public static final String API = "api";
    public static final String LOGIN = "login";
    public static final String LOGOUT = "logout";
    public static final String TOKEN = "token";

    public static final String SYMBOLS_FORWARD_SLASH = "/";
    public static final String SYMBOLS_OPEN_CURLY = "{";
    public static final String SYMBOLS_CLOSE_CURLY = "}";

    public static final String ENDPOINT_API = SYMBOLS_FORWARD_SLASH + API;
    public static final String ENDPOINT_USERS = SYMBOLS_FORWARD_SLASH + USERS;
    public static final String ENDPOINT_USER_ID = SYMBOLS_FORWARD_SLASH + SYMBOLS_OPEN_CURLY + USER_ID + SYMBOLS_CLOSE_CURLY;
    public static final String USERS_API_BASE_URL = ENDPOINT_API + ENDPOINT_USERS + ENDPOINT_USER_ID;
    public static final String ENDPOINT_LOGIN = SYMBOLS_FORWARD_SLASH + LOGIN;
    public static final String ENDPOINT_LOGOUT = SYMBOLS_FORWARD_SLASH + LOGOUT;
    public static final String ENDPOINT_TOKEN = SYMBOLS_FORWARD_SLASH + TOKEN;
}
