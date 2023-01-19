package com.sixsense.liargame.common.auth;

public interface JwtProperties {
    String SECRET = "***REMOVED***"; // 우리 서버만 알고 있는 비밀값
    int ACCESS_TOKEN_TIME =  1000 * 60 * 30;
    int REFRESH_TOKEN_TIME = 6 * 24 * 60 * 60 * 1000;
}
