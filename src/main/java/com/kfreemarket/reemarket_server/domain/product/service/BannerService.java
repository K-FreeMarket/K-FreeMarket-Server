package com.kfreemarket.reemarket_server.domain.product.service;

import com.kfreemarket.reemarket_server.domain.product.dto.BannerDto;
import com.kfreemarket.reemarket_server.domain.product.entity.Banner;
import com.kfreemarket.reemarket_server.domain.product.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BannerService {

    private final BannerRepository bannerRepository;

    public List<BannerDto> getAllBanners() {
        List<Banner> bannerList =  bannerRepository.findAll();
        return bannerList.stream().map(BannerDto::of).toList();
    }

}
