package com.kfreemarket.reemarket_server.domain.product.dto;

import com.kfreemarket.reemarket_server.domain.product.entity.Banner;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BannerDto {

    private Long id;

    private String bannerTitle;

    private String bannerImageUrl;

    private String linkUrl;

    private Integer priority;

    private Boolean active;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    public static BannerDto of(Banner banner) {
        return new BannerDto(
                banner.getId(),
                banner.getBannerTitle(),
                banner.getBannerImageUrl(),
                banner.getLinkUrl(),
                banner.getPriority(),
                banner.getIsActive(),
                banner.getStartAt(),
                banner.getEndAt()
        );
    }
}
