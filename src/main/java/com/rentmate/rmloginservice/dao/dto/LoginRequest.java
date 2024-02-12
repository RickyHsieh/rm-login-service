package com.rentmate.rmloginservice.dao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * LoginDto. 2024/02/12 19:44
 * Description:
 * Author: Ricky
 *
 * @version 1.0.0
 */
@Getter
@Setter
public class LoginRequest {

    @JsonProperty("username")
    private String username = "";

    @JsonProperty("password")
    private String password = "";

}
