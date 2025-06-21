package com.kfreemarket.reemarket_server.domain.user.repository;

import com.kfreemarket.reemarket_server.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserReposiotry extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
