package com.kfreemarket.reemarket_server.domain.user.repository;

import com.kfreemarket.reemarket_server.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);

    User findByName(String name);
}
