package com.kfreemarket.reemarket_server.domain.user.dto;

import com.kfreemarket.reemarket_server.global.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private UserRole role;

    private String name;

    private String username;
}
