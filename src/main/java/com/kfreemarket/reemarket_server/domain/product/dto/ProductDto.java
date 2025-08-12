package com.kfreemarket.reemarket_server.domain.product.dto;

import com.kfreemarket.reemarket_server.domain.product.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDto {

    private Long id;

    private String productName;

    private Long productPrice;

    private Integer stock;

    private Integer salesCount;

    public static ProductDto of (Product product) {
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getProductPrice(),
                product.getStock(),
                product.getSalesCount()
        );
    }


}
