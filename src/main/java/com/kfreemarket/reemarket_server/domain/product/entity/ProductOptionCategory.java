package com.kfreemarket.reemarket_server.domain.product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class ProductOptionCategory {

    @Id
    @Column(name = "product_option_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String categoryName;

    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "productOptionCategory", fetch = FetchType.LAZY)
    private List<ProductOptionValue> productOptionValues;

    @OneToMany(mappedBy = "productOptionCategory", fetch = FetchType.LAZY)
    private List<ProductOptionCategoryMap> productOptionCategoryMaps;

    @Builder
    public ProductOptionCategory(String categoryName, List<ProductOptionValue> productOptionValues, List<ProductOptionCategoryMap> productOptionCategoryMap){
        this.categoryName = categoryName;
        this.productOptionValues = productOptionValues;
        this.productOptionCategoryMaps = productOptionCategoryMap;
    }

}
