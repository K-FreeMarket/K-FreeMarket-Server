package com.kfreemarket.reemarket_server.domain.product.entity;

import com.kfreemarket.reemarket_server.domain.order.entity.OrderItem;
import com.kfreemarket.reemarket_server.domain.user.entity.Question;
import com.kfreemarket.reemarket_server.domain.user.entity.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;



@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @Column(name = "product_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name",nullable = false, unique = true)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private Long productPrice;

    @Column(nullable = false)
    private Integer stock;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer salesCount;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Discount> discounts;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOptionCategoryMap> productOptionCategoryMaps;

    @Builder
    public Product(String productName, Long productPrice, Integer stock, Integer salesCount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.stock = stock;
        this.salesCount = salesCount;
    }

}
