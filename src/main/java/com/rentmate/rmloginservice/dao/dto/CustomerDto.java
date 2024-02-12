package com.rentmate.rmloginservice.dao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * CustomerDto. 2024/02/10 01:09
 * Description:
 * Author: Ricky
 *
 * @version 1.0.0
 */
@Getter
@Setter
public class CustomerDto {

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("userName")
    private String username;

    @JsonProperty("customerId")
    private String custId;

    @JsonProperty("contactNumber")
    private String contactNumber;

    @JsonProperty("emailAddress")
    private String emailAddress;

    @JsonProperty(value = "pwd", access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    @JsonProperty("role")
    private String role;
}
