package com.rentmate.rmloginservice.controller;

import com.rentmate.rmloginservice.dao.dto.LoginRequest;
import com.rentmate.rmloginservice.dao.dto.LoginResponse;
import com.rentmate.rmloginservice.framework.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * LoginController. 2024/02/12 20:44
 * Description:
 * Author: Ricky
 *
 * @version 1.0.0
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginDto) {
        log.info("Login Start");
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = JwtUtil.generateToken(authentication);

            LoginResponse response = new LoginResponse();
            response.setToken(jwt);
            response.setStatus("ok");
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            log.error("登入失敗");
            return ResponseEntity.badRequest().body("Authentication failed");
        }
    }
}
