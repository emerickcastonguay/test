package dev.fyloz.colval.jee.thymeleaf.cours.security;

public class JwtProperties {
    public static final String SECRET = "SpringBootTD";
    public static final int EXPIRATION_TIME = 864000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
