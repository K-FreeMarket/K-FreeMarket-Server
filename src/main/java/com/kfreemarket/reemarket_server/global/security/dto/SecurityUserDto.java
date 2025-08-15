package com.kfreemarket.reemarket_server.global.security.dto;

import com.kfreemarket.reemarket_server.global.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityUserDto {

    private UserRole role;

    private String name;

    private String username;
}
