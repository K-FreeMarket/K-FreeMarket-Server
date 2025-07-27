package com.kfreemarket.reemarket_server.global.security.oauth2;

import com.kfreemarket.reemarket_server.domain.system.repository.RefreshTokenRepository;
import com.kfreemarket.reemarket_server.global.security.dto.CustomOAuth2User;
import com.kfreemarket.reemarket_server.global.security.jwt.JWTUtil;
import com.kfreemarket.reemarket_server.global.security.service.JwtSupportService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

@Component
@RequiredArgsConstructor
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JWTUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtSupportService jwtSupportService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        //OAuth2User
        CustomOAuth2User customUserDetails = (CustomOAuth2User) authentication.getPrincipal();

        String username = customUserDetails.getUsername();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority auth = iterator.next();
        String role = auth.getAuthority();

        String refresh = jwtUtil.createJwt("refresh", username, role, 60 * 60 * 24 * 1000L);

        //Refresh 토큰 저장
        jwtSupportService.addRefreshEntity(username, refresh, 60 * 60 * 24 * 1000L);


        response.addCookie(jwtSupportService.createCookie("refresh", refresh));
        response.sendRedirect("http://localhost:3000/login?access=true");

    }


}
