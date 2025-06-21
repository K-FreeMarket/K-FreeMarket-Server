package com.kfreemarket.reemarket_server.domain.user.dto;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String username;
    private String password;
}
