package com.kfreemarket.reemarket_server.domain.user.controller;

import com.kfreemarket.reemarket_server.domain.user.entity.User;
import com.kfreemarket.reemarket_server.domain.user.repository.UserRepository;
import com.kfreemarket.reemarket_server.domain.user.service.UserService;
import com.kfreemarket.reemarket_server.global.validator.UserValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UserViewController {

    private final UserService userService;
    private final UserRepository  userRepository;
    private final UserValidator userValidator;

    @GetMapping
    public String Login(Model model) {
        return "index";
    }

    @GetMapping("/users")
    public String userView(Model model) {

        model.addAttribute("users", userService.getAllUsers());
        return "/user/user";
    }

    @GetMapping("/form")
    public String formView(Model model, @RequestParam(required = false) String name) {
        if (name == null) {
            model.addAttribute("user", User.builder().build());
        }else{
            User user = userRepository.findByName(name);
            model.addAttribute("user", User.builder().
                    id(user.getId()).
                    username(user.getUserName()).
                    name(user.getName()).
                    mobileNumber(user.getMobileNumber()).
                    address(user.getAddress()).
                    build());
        }

        return "/user/form";
    }

    @PostMapping("/form")
    public String postForm(@Valid User user, BindingResult bindingResult) {

        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/user/form";
        }

        User user1 = userRepository.findByName(user.getName());

        if (user1 != null) {
            User updateUser = User.builder().
                    id(user1.getId()).
                    username(user1.getUserName()).
                    name(user1.getName()).
                    userRole(user1.getUserRole()).
                    mobileNumber(user.getMobileNumber()).
                    address(user.getAddress()).
                    email(user1.getEmail()).
                    build();
            userRepository.save(updateUser);
        }


        return "redirect:/admin/users";
    }

}
