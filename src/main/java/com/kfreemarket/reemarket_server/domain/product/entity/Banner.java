package com.kfreemarket.reemarket_server.domain.product.entity;

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
public class Banner {

    @Id
    @Column(name = "baaner_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="banner_title", nullable = false)
    private String bannerTitle;

    @Column(name = "banner_image_url", nullable = false, columnDefinition = "TEXT")
    private String bannerImageUrl;

    @Column(name="link_url", nullable = true, columnDefinition = "TEXT")
    private String linkUrl;

    private Integer priority;

    @Column(name="is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "start_at", nullable = false)
    private LocalDateTime startAt;

    @Column(name = "end_at", nullable = false)
    private LocalDateTime endAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id", nullable = true)
    private Discount discount;

    @Builder
    public Banner(String bannerTitle, String imageUrl, String linkUrl, Integer priority, Boolean isActive, LocalDateTime startAt, LocalDateTime endAt) {
        this.bannerTitle = bannerTitle;
        this.bannerImageUrl = imageUrl;
        this.linkUrl = linkUrl;
        this.priority = priority;
        this.isActive = isActive;
        this.startAt = startAt;
        this.endAt = endAt;
    }
}
