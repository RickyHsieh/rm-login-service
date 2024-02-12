package com.rentmate.rmloginservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RM001003Controller. 2024/02/09 15:33
 * Description:
 * Author: Ricky
 *
 * @version 1.0.0
 */
@Slf4j
@RestController
public class RM001003Controller {
    @GetMapping("/RM001003")
    public String testRm001003() {

        log.info("RM001003 start");
        return "I am rent lord.";
    }
}
