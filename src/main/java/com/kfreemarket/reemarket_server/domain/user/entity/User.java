package com.kfreemarket.reemarket_server.domain.user.entity;

import com.kfreemarket.reemarket_server.domain.order.entity.Orders;
import com.kfreemarket.reemarket_server.global.enums.UserRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name = "mobile_number", unique = true, nullable = true, length = 15)
    private String mobileNumber;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //mappedBy = cartItems에 연결된 필드 명
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Question> questions;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Orders> orders;


    // 생성자 @Builder
    @Builder
    public User(String username, String name,String mobileNumber, String address, UserRole userRole, String email, LocalDateTime created_at, LocalDateTime updated_at) {
        this.userName = username;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.userRole = userRole;
        this.email = email;
    }

}
