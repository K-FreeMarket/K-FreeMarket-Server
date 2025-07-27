package com.kfreemarket.reemarket_server.domain.user.controller;

import com.kfreemarket.reemarket_server.domain.user.dto.UserPageDto;
import com.kfreemarket.reemarket_server.domain.user.repository.UserRepository;
import com.kfreemarket.reemarket_server.domain.user.service.UserService;
import com.kfreemarket.reemarket_server.global.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
    public String userView(Model model, @PageableDefault(size = 20) Pageable pageable, @RequestParam(required = false, defaultValue = "") String searchText, @RequestParam(defaultValue = "idAsc") String sort) {
        UserPageDto userPageDto = userService.getAllUsers(pageable, searchText, sort);

        model.addAttribute("startPage", userPageDto.getStartPage());
        model.addAttribute("endPage", userPageDto.getEndPage());
        model.addAttribute("users", userPageDto.getUsers());
        model.addAttribute("sort", sort);
        return "/user/user";
    }

    @DeleteMapping("/user")
    public String deleteUser(@RequestParam Long userId, RedirectAttributes redirectAttributes) {
        Boolean deleted = userService.deleteUser(userId);

        if(deleted){
            redirectAttributes.addFlashAttribute("message", "삭제 성공");

        }else {
            redirectAttributes.addFlashAttribute("error", "삭제 실패");
        }
        return "redirect:/admin/users";

    }
}
