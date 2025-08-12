package com.kfreemarket.reemarket_server.domain.product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(
        name = "ProductOptionCategoryMap",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_product_category",
                columnNames = {"product_id", "product_option_category_id"}
        )
)

public class ProductOptionCategoryMap {

    @Id
    @Column(name="product_option_category_map_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer sortOrder;

    private Boolean required;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_category_id", nullable = false)
    private ProductOptionCategory productOptionCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Builder
    public ProductOptionCategoryMap(Integer sortOrder, Boolean required, ProductOptionCategory productOptionCategory, Product product) {
        this.sortOrder = sortOrder;
        this.required = required;
        this.productOptionCategory = productOptionCategory;
        this.product = product;
    }
}
