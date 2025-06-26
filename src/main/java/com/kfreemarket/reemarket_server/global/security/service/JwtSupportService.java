package com.kfreemarket.reemarket_server.global.security.service;

import com.kfreemarket.reemarket_server.domain.system.entity.RefreshToken;
import com.kfreemarket.reemarket_server.domain.system.repository.RefreshTokenRepository;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtSupportService {

    private final RefreshTokenRepository refreshTokenRepository;

    /**
     * RefreshToken 저장
     */
    public void addRefreshEntity(String username, String refresh, Long expiredMs) {
        Date date = new Date(System.currentTimeMillis() + expiredMs);

        RefreshToken refreshToken = RefreshToken.builder()
                .username(username)
                .refresh(refresh)
                .expiration(date.toString())
                .build();

        refreshTokenRepository.save(refreshToken);
    }

    /**
     * HttpOnly 쿠키 생성
     */
    public Cookie createCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(24*60*60);
        //cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        return cookie;
    }
}
