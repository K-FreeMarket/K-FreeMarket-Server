package com.kfreemarket.reemarket_server.domain.product.service;


import com.kfreemarket.reemarket_server.domain.product.dto.ProductDto;
import com.kfreemarket.reemarket_server.domain.product.entity.Product;
import com.kfreemarket.reemarket_server.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> getTopProducts() {
        List<Product> products = productRepository.findTop5ByOrderBySalesCountDesc();

        if (products.isEmpty()) {
            return List.of();
        }

        return products.stream().map(ProductDto::of).toList();
    }
}
