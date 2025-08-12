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
        name = "ProductOptionValue",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_option_value_category_name",
                columnNames = {"product_option_category_id", "optionName"}
        )
)
public class ProductOptionValue {

    @Id
    @Column(name = "product_option_value_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String optionName;

    private Long additionalPrice;

    private Integer sortOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_option_category_id", nullable = false)
    private  ProductOptionCategory productOptionCategory;

    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public ProductOptionValue(String optionName, Long additionalPrice, Integer sortOrder, ProductOptionCategory productOptionCategory) {
        this.optionName = optionName;
        this.additionalPrice = additionalPrice;
        this.sortOrder = sortOrder;
        this.productOptionCategory = productOptionCategory;
    }
}
