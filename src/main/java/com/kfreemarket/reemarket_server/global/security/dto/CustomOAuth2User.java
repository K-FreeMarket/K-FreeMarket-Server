package com.kfreemarket.reemarket_server.global.security.dto;

import com.kfreemarket.reemarket_server.global.security.dto.SecurityUserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;

import java.util.Map;

public class CustomOAuth2User implements OAuth2User {

    private final SecurityUserDto securityUserDto;

    public CustomOAuth2User(SecurityUserDto securityUserDto){
        this.securityUserDto = securityUserDto;
    }


    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {

                return securityUserDto.getRole().name();
            }
        });

        return collection;

    }

    @Override
    public String getName() {
        return securityUserDto.getName();
    }

    public String getUsername() {
        return securityUserDto.getUsername();
    }
}
