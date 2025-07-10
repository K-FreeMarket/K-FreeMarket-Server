package com.kfreemarket.reemarket_server.domain.user.dto;

import com.kfreemarket.reemarket_server.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponse {

    private Long id;

    private String name;

    private String userRole;

    private String mobileNumber;

    private String address;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static UserResponse of(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getUserRole().name(),
                user.getMobileNumber(),
                user.getAddress(),
                user.getEmail(),
                user.getCreated_at(),
                user.getUpdated_at()
        );
    }
}
