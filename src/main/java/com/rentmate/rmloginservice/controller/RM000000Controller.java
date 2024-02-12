package com.rentmate.rmloginservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RM000000. 2024/02/09 15:38
 * Description:
 * Author: Ricky
 *
 * @version 1.0.0
 */
@RestController
public class RM000000Controller {

    @GetMapping("/RM000000")
    public String RM000000Test() {
        return "Free to look everything.";
    }

}
