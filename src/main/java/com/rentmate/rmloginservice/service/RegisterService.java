package com.rentmate.rmloginservice.service;

import com.rentmate.rmloginservice.dao.dto.RegisterRequest;
import com.rentmate.rmloginservice.dao.model.Customer;
import com.rentmate.rmloginservice.dao.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.rentmate.rmloginservice.framework.utils.ParamValidation.checkAllParamValid;
import static com.rentmate.rmloginservice.framework.utils.TimeUtils.getNowFormattedTime;

/**
 * RM001001Service. 2024/02/09 23:22
 * Description:
 * Author: Ricky
 *
 * @version 1.0.0
 */
@Service
@Slf4j
public class RegisterService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> registerHelper(RegisterRequest request) {

        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String username = request.getUsername();
        String custId = request.getCustId();
        String contactNumber = request.getContactNumber();
        String emailAddress = request.getEmailAddress();
        String role = request.getRole();
        String pwd = request.getPwd();


        if (!checkAllParamValid(lastName, firstName, username, custId, pwd, contactNumber, emailAddress, role)) {
            return ResponseEntity.badRequest().body("All fields are required and cannot be empty.");
        }

        try {


            RegisterRequest dto = new RegisterRequest();
            dto.setLastName(lastName);
            dto.setFirstName(firstName);
            dto.setUsername(username);
            dto.setCustId(custId);
            dto.setPwd(pwd);
            dto.setContactNumber(contactNumber);
            dto.setEmailAddress(emailAddress);
            dto.setRole(role);

            Customer customer = toEntity(dto);
            customer.setCreatedAt(getNowFormattedTime());
            customer.setPwd(encrypt(dto.getPwd()));

            Customer savedCustomer = customerRepository.save(customer);
            if (savedCustomer.getMemberId() != null) {
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            } else {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Registration failed, memberId was not generated.");
            }
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred due to: " + ex.getMessage());
        }
    }

    private Customer toEntity(RegisterRequest dto) {
        Customer customer = new Customer();
        customer.setLastName(dto.getLastName());
        customer.setFirstName(dto.getFirstName());
        customer.setUsername(dto.getUsername());
        customer.setCustId(dto.getCustId());
        customer.setContactNumber(dto.getContactNumber());
        customer.setEmailAddress(dto.getEmailAddress());
        customer.setAccountVerified("1"); // 需驗證時再做更改
        customer.setPwd(dto.getPwd());
        customer.setRole(dto.getRole());

        // role, thirdPartyAuthType, thirdPartyAuthId, lastLoginTime
        return customer;
    }

    private String encrypt(String pwd) {
        return passwordEncoder.encode(pwd);
    }

    /**
     * 取得第三方授權
     */
    private void getThirdPartyAuth() {
    }

    /**
     * 驗證帳號
     * 1 已驗證
     * 0 未驗證
     */
    private void verifiedAccount() {
    }
}
