package com.kfreemarket.reemarket_server.admin.dto;

import com.kfreemarket.reemarket_server.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AdminUserPageDto {

    private Page<User> users;
    private int startPage;
    private int endPage;

    public static AdminUserPageDto of(Page<User> users) {
        int currentPage = users.getNumber();
        int totalPages = users.getTotalPages();

        int startPage = Math.max(1, currentPage - 4);
        int endPage = Math.min(totalPages, currentPage + 4);

        return new AdminUserPageDto(users, startPage, endPage);
    }
}
