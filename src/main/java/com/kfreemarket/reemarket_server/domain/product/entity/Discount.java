package com.kfreemarket.reemarket_server.domain.product.entity;

import com.kfreemarket.reemarket_server.global.enums.DiscountType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Discount {

    @Id
    @Column(name = "discount_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private Integer value;

    private LocalDateTime start_at;

    private LocalDateTime end_at;

    @Column(name = "is_active")
    private Boolean isActive;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Builder
    public Discount( DiscountType discountType, Integer value, LocalDateTime start_at, LocalDateTime end_at, Boolean isActive) {
        this.discountType = discountType;
        this.value = value;
        this.start_at = start_at;
        this.end_at = end_at;
        this.isActive = isActive;
    }

}