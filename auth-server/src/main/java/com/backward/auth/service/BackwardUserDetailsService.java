package com.backward.auth.service;

import com.backward.account.client.AccountClient;
import com.backward.account.dto.response.UserDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BackwardUserDetailsService implements UserDetailsService {

    @Autowired
    AccountClient accountClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDetails userDetails = User.withUsername("one").password(BCrypt.hashpw("123", BCrypt.gensalt())).authorities("p1").build();
        UserDetailResponse response = accountClient.getUserDetails(username);
        System.out.println(response);
        OAuthUserDetails userDetails = new OAuthUserDetails(response.getUserDetailsDto());
        return userDetails;
    }
}
