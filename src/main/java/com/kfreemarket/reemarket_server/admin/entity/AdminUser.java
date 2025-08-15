package com.kfreemarket.reemarket_server.admin.entity;

import com.kfreemarket.reemarket_server.global.enums.UserRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true, length=50)
    private String username;

    @Column(nullable=false, length=100)
    private String password; // BCrypt

    @Enumerated(EnumType.STRING)
    private UserRole userRole; // "ROLE_ADMIN"

    @Column(nullable=false)
    private boolean enabled = true;

    @Builder
    public AdminUser(Long id, String username, String password, UserRole userRole, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.enabled = enabled;
    }

}
