package com.rentmate.rmloginservice.framework.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

/**
 * SecurityConstants. 2024/02/12 13:31
 * Description: 自訂密鑰、Header
 * Author: Ricky
 *
 * @version 1.0.0
 */
public interface SecurityConstants {
    SecretKey JWT_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    String JWT_HEADER = "";
}
