package com.rentmate.rmloginservice.framework.config;

import com.rentmate.rmloginservice.dao.model.Customer;
import com.rentmate.rmloginservice.dao.repository.CustomerRepository;
import com.rentmate.rmloginservice.framework.dao.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * UsernamePwdAuthentication. 2024/02/10 17:49
 * Description:
 * Author: Ricky
 *
 * @version 1.0.0
 */
@Component
public class UsernamePwdAuthentication implements AuthenticationProvider {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        Optional<Customer> customer = customerRepository.findByEmailAddress(username);
        if(customer.isPresent()) {
            if(passwordEncoder.matches(pwd, customer.get().getPwd())) {

                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(customer.get().getAuthorities()));
            } else {
                throw new BadCredentialsException("Invalid password.");
            }
        }else {
            throw new BadCredentialsException("No user registered with this detail.");
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
