package com.rentmate.rmloginservice.controller;

import com.rentmate.rmloginservice.dao.dto.RegisterRequest;
import com.rentmate.rmloginservice.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RM000000. 2024/02/09 12:06
 * Description: login controller
 * Author: Ricky
 *
 * @version 1.0.0
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService service;

    @PostMapping("/insert")
    public ResponseEntity<String> doPost(@RequestBody RegisterRequest request) {

        return service.registerHelper(request);
    }
}
