package com.rentmate.rmloginservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RM001002Controller. 2024/02/09 15:30
 * Description:
 * Author: Ricky
 *
 * @version 1.0.0
 */
@RestController
public class UserController {
    @GetMapping("/user")
    public String getTest() {
        return "User page ";
    }
}
