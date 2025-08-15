package com.kfreemarket.reemarket_server.global.security.service;

import com.kfreemarket.reemarket_server.admin.entity.AdminUser;
import com.kfreemarket.reemarket_server.admin.repository.AdminUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserDetailsService implements UserDetailsService {

    private final AdminUserRepository adminUserRepository; // 관리자용 저장소

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser admin = adminUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("관리자 계정 없음: " + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(admin.getUsername())
                .password(admin.getPassword())      // BCrypt 저장
                .authorities(admin.getUserRole().name())       // "ROLE_ADMIN"
                .accountLocked(!admin.isEnabled())
                .disabled(!admin.isEnabled())
                .build();
    }
}
