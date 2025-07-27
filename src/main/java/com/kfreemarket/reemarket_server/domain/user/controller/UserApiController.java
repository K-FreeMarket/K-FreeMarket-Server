package com.kfreemarket.reemarket_server.domain.user.controller;

import com.kfreemarket.reemarket_server.domain.user.dto.UserDTO;
import com.kfreemarket.reemarket_server.global.enums.UserRole;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @GetMapping()
    public ResponseEntity<UserDTO> getUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("kfreemarket");
        userDTO.setRole(UserRole.ROLE_USER);
        userDTO.setName("dndnd");
        return ResponseEntity.ok(userDTO);
    }

}
