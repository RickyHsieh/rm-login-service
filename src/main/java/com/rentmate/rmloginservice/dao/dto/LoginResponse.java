package com.rentmate.rmloginservice.dao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

/**
 * LoginResponse. 2024/02/12 20:00
 * Description:
 * Author: Ricky
 *
 * @version 1.0.0
 */
@Setter
public class LoginResponse {
    @JsonProperty("token")
    private String token;

    @JsonProperty("status")
    private String status;

}
