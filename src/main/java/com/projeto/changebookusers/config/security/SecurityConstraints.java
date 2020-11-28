package com.projeto.changebookusers.config.security;

public class SecurityConstraints {

    //static final String SECRET = "ChangeBookAuth";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SING_UP_URL = "/api/change-book/v1/users/sign-up";
    public static final String TOKEN_VALIDADTION_URL = "/api/change-book/v1/users/token-valid";
    public static final long EXPIRARION_TIME = 84600000L;

}
