package com.rentmate.rmloginservice.framework.utils;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.rentmate.rmloginservice.framework.config.SecurityConstants.JWT_EXPIRED;
import static com.rentmate.rmloginservice.framework.config.SecurityConstants.JWT_KEY;

public class JwtUtil {

    private static final SecretKey key = JWT_KEY;
    private static final long expired = JWT_EXPIRED;

    public static String generateToken(Authentication authentication) {

        Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            authoritiesSet.add(authority.getAuthority());
        }
        String authorities = String.join(",", authoritiesSet);

        return Jwts.builder()
                .setIssuer("RentMate")
                .setSubject("JWT Token")
                .claim("username", authentication.getName())
                .claim("authorities", authorities)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expired))
                .signWith(key)
                .compact();
    }
}
