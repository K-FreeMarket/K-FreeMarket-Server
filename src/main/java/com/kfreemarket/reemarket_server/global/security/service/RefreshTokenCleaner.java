package com.kfreemarket.reemarket_server.global.security.service;

import com.kfreemarket.reemarket_server.domain.system.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class RefreshTokenCleaner {
    private final RefreshTokenRepository refreshTokenRepository;

    @Scheduled(cron = "0 0 4 * * ?")
    public void deleteExpiredData() {
        refreshTokenRepository.deleteByExpirationBefore(LocalDateTime.now());
    }
}
