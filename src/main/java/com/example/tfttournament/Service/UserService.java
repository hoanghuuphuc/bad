package com.example.tfttournament.Service;

import com.example.tfttournament.dao.AccountDao;
import com.example.tfttournament.model.User;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    AccountDao accountDao;

//    @Autowired
//    BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User account = accountDao.findbyUsername(username);

//            if (!account.getTps_Active()) {
//                throw new UsernameNotFoundException(username + " is not active!");
//            }
            String storedPassword = account.getPassword();
            return org.springframework.security.core.userdetails.User.withUsername(username)
                    .password(storedPassword)
//                    .roles(account.getUserRoles().stream()
//                            .map(au -> au.getRole().getId())
//                            .collect(Collectors.toList())
//                            .toArray(new String[0]))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(username + " not found!");
        }
    }



}
