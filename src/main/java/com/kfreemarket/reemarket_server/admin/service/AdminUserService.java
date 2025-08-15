package com.kfreemarket.reemarket_server.admin.service;

import com.kfreemarket.reemarket_server.admin.dto.AdminUserPageDto;
import com.kfreemarket.reemarket_server.domain.user.entity.User;
import com.kfreemarket.reemarket_server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminUserService {

    private final UserRepository userRepository;

    public AdminUserPageDto getAllUsers(Pageable pageable, String searchText, String sort) {
        Pageable sortedPageable = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                getSortOption(sort)
        );

        Page<User> users = userRepository.findAllByNameContainingOrEmailContainingOrMobileNumberContainingOrAddressContaining(
                searchText, searchText, searchText, searchText, sortedPageable
        );

        return AdminUserPageDto.of(users);
    }

    private Sort getSortOption(String sort) {
        Map<String, Sort> sortMap = Map.of(
                "idAsc", Sort.by(Sort.Direction.ASC, "id"),
                "nameAsc", Sort.by(Sort.Direction.ASC, "name"),
                "idDesc", Sort.by(Sort.Direction.DESC, "id") // 기본값
        );

        return sortMap.getOrDefault(sort, Sort.by(Sort.Direction.DESC, "id"));
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
