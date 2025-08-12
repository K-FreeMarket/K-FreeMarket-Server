package com.kfreemarket.reemarket_server.domain.product.controller;

import com.kfreemarket.reemarket_server.domain.product.dto.BannerDto;
import com.kfreemarket.reemarket_server.domain.product.dto.ProductDto;
import com.kfreemarket.reemarket_server.domain.product.service.BannerService;
import com.kfreemarket.reemarket_server.domain.product.service.ProductService;
import com.kfreemarket.reemarket_server.global.api.ApiResponse;
import lombok.RequiredArgsConstructor;
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
    public ApiResponse<List<BannerDto>> getBanner() {
        List<BannerDto> bannerDTOs = bannerService.getAllBanners();
        return ApiResponse.success(bannerDTOs);
    }

    @GetMapping("/top")
    public ApiResponse<List<ProductDto>> getTopProduct() {
        List<ProductDto> topProductDTOs = productService.getTopProducts();
        return ApiResponse.success(topProductDTOs);
    }
}
