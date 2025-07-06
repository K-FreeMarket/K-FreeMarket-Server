package com.kfreemarket.reemarket_server.domain.product.controller;

import com.kfreemarket.reemarket_server.domain.product.dto.BannerDto;
import com.kfreemarket.reemarket_server.domain.product.dto.ProductDto;
import com.kfreemarket.reemarket_server.domain.product.service.BannerService;
import com.kfreemarket.reemarket_server.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductApiController {

    private final BannerService bannerService;
    private final ProductService productService;

    @GetMapping("/banners")
    public ResponseEntity<List<BannerDto>> getBanner() {
        List<BannerDto> bannerDtos = bannerService.getAllBanners();
        return ResponseEntity.ok(bannerDtos);
    }

    @GetMapping("/top")
    public ResponseEntity<List<ProductDto>> getTopProduct() {
        List<ProductDto> topProductDtos = productService.getBestProducts();
        return ResponseEntity.ok(topProductDtos);
    }
}
