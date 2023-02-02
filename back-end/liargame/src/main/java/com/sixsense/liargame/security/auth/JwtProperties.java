package com.sixsense.liargame.security.auth;

public interface JwtProperties {
    String SECRET = "***REMOVED***"; // 우리 서버만 알고 있는 비밀값
    long ACCESS_TOKEN_TIME = 1000L * 60 * 30;
    long REFRESH_TOKEN_TIME = 7 * 24 * 60 * 60 * 1000L;
    String AUTHORITIES_KEY = "auth";
    String BEARER_TYPE = "Bearer";
    String ACCESS_TOKEN = "access-token";
}
