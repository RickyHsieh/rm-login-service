package com.rentmate.rmloginservice.framework.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

/**
 * SecurityConstants. 2024/02/12 13:31
 * Description: 自訂密鑰、Header
 * Author: Ricky
 *
 * @version 1.0.0
 */

@Component
public class SecurityConstants {

    private static String secretKey;

    @Value("${jwt.secret}")
    public String secretKeyValue;

    public static SecretKey JWT_KEY;

    public static final String JWT_HEADER = "";

    public static final long JWT_EXPIRED = 3600000;

    @PostConstruct
    private void init() {
        secretKey = secretKeyValue;
        JWT_KEY = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }
}