package com.kfreemarket.reemarket_server.domain.user.service;

import com.kfreemarket.reemarket_server.domain.user.dto.UserPageDto;
import com.kfreemarket.reemarket_server.domain.user.entity.User;
import com.kfreemarket.reemarket_server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserPageDto getAllUsers(Pageable pageable, String searchText) {
        Page<User> users = userRepository.findAllByNameContainingOrEmailContainingOrMobileNumberContainingOrAddressContaining(searchText,searchText,searchText, searchText,pageable);

        return UserPageDto.of(users);
    }

    @Transactional
    public Boolean deleteUser(Long userId) {
        try{
            userRepository.deleteById(userId);
            return true;
        }catch (Exception e){
            log.error("Failed to delete user id={}", userId, e);
            return false;
        }
    }
}
