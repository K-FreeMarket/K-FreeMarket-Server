package com.kfreemarket.reemarket_server.domain.product.repository;

import com.kfreemarket.reemarket_server.domain.product.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, Long> {

    List<Banner> findAll();
}
