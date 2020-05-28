package com.backward.auth.service;

import com.alibaba.fastjson.JSON;
import com.backward.account.dto.UserDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OAuthUserDetails implements UserDetails {

    private UserDetailsDto userDetailsDto;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> authorities = JSON.parseArray(userDetailsDto.getAuthorities(), String.class);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(String authority : authorities){
           grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return userDetailsDto.getPassword();
    }

    @Override
    public String getUsername() {
        return userDetailsDto.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
