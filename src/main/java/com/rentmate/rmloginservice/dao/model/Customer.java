package com.rentmate.rmloginservice.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rentmate.rmloginservice.framework.dao.model.Authority;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "cust_id", nullable = false, length = 20)
    private String custId;

    @Column(name = "contact_number", nullable = false, length = 20)
    private String contactNumber;

    @Column(name = "email_address", nullable = false, length = 50)
    private String emailAddress;

    @Column(name = "account_verified", length = 2)
    private String accountVerified;

    @Column(name = "role", nullable = false, length = 20)
    private String role;

    @Column(name = "pwd", nullable = false, length = 50)
    private String pwd;

    @Column(name = "third_party_auth_type", length = 100)
    private String thirdPartyAuthType;

    @Column(name = "third_party_auth_id", length = 100)
    private String thirdPartyAuthId;

    @Column(name = "create_at", length = 50)
    private String createdAt;

    @Column(name = "last_login_time", length = 50)
    private String lastLoginTime;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Authority> authorities;
}
