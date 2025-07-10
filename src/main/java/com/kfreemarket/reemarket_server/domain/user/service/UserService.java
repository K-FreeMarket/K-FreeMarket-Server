package com.kfreemarket.reemarket_server.domain.user.service;

import com.kfreemarket.reemarket_server.domain.user.dto.UserResponse;
import com.kfreemarket.reemarket_server.domain.user.entity.User;
import com.kfreemarket.reemarket_server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            return List.of();
        }

        return users.stream().map(UserResponse::of).toList();
    }
}
