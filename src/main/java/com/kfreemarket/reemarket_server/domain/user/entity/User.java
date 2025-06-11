package com.kfreemarket.reemarket_server.domain.user.entity;

import com.kfreemarket.reemarket_server.global.enums.UserRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "user_id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private String mobile_number;

    private String address;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //mappedBy = cartItems에 연결된 필드 명
    private List<CartItem> cartItems;

    // 생성자 @Builder
    @Builder
    public User(String username,String mobile_number, String address, UserRole userRole) {
        this.userName = username;
        this.mobile_number = mobile_number;
        this.address = address;
        this.userRole = userRole;
    }
}
