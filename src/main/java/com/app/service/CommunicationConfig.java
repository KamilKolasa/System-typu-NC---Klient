package com.app.service;

public interface CommunicationConfig {

    String BASE_URL = "http://localhost:8081/";
    String MAIN_URL = BASE_URL + "main/";
    String SECURITY_URL = BASE_URL + "security/";
    String ADMIN_URL = BASE_URL + "admin/";
    String USER_URL = BASE_URL + "user/";
    String TOKEN_PREFIX = "Bearer ";
    String TOKEN_HEADER = "Authorization";

}
