package com.rentmate.rmloginservice.framework.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.rentmate.rmloginservice.framework.config.SecurityConstants.JWT_KEY;

/**
 * JWTGeneratorFilter. 2024/02/12 13:08
 * Description: generated jwt token
 * Author: Ricky
 *
 * @version 1.0.0
 */
public class JWTGeneratorFilter extends OncePerRequestFilter {

    private final SecretKey key = JWT_KEY;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication && authentication.isAuthenticated()) {

            String jwt = Jwts.builder()
                    .setIssuer("RentMate")
                    .setSubject("JWT Token")
                    .claim("username", authentication.getName())
                    .claim("authorities", populateAuthorities(authentication.getAuthorities()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 過期時間 1 小時
                    .signWith(key)
                    .compact();

            response.addHeader("Authorization", "Bearer " + jwt);
        }
        filterChain.doFilter(request, response);
    }

    /**
     * 細粒度控制
     * 哪些請求需要經過此filter
     * @param request
     * @return
     * @throws ServletException
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/user");
    }

    /**
     * 將一個實作了GrantedAuthority介面的物件集合轉換成一個以逗號分隔的字串，表示權限（或角色）
     * @param collection
     * @return
     */
    private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> authoritiesSet = new HashSet<>();
        for(GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
    }
}
