//package com.rentmate.rmloginservice.framework.config;
//
//import com.rentmate.rmloginservice.dao.model.Customer;
//import com.rentmate.rmloginservice.dao.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserDetails implements UserDetailsService {
//
//    @Autowired
//    CustomerRepository customerRepository;
//
//    @Override
//    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Customer> customerOptional = customerRepository.findByEmailAddress(username);
//        if (customerOptional.isPresent()) {
//            Customer customer = customerOptional.get();
//            String password = customer.getPwd();
//            String role = customer.getRole();
//            List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(role));
//            return new User(username, password, authorities);
//        } else {
//            throw new UsernameNotFoundException("User detail not found for the user: " + username);
//        }
//    }
//
//}
