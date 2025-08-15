package com.kfreemarket.reemarket_server.admin.controller;

import com.kfreemarket.reemarket_server.admin.dto.AdminUserPageDto;
import com.kfreemarket.reemarket_server.admin.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminUserController {

    private final AdminUserService adminUserService;

    @GetMapping("/users")
    public String userView(Model model, @PageableDefault(size = 20) Pageable pageable, @RequestParam(required = false, defaultValue = "") String searchText, @RequestParam(defaultValue = "idAsc") String sort) {
        AdminUserPageDto adminUserPageDto = adminUserService.getAllUsers(pageable, searchText, sort);

        model.addAttribute("startPage", adminUserPageDto.getStartPage());
        model.addAttribute("endPage", adminUserPageDto.getEndPage());
        model.addAttribute("users", adminUserPageDto.getUsers());
        model.addAttribute("sort", sort);
        return "/user/user";
    }

    @DeleteMapping("/user")
    public String deleteUser(@RequestParam Long userId, RedirectAttributes redirectAttributes) {
        Boolean deleted = adminUserService.deleteUser(userId);

        if(deleted){
            redirectAttributes.addFlashAttribute("message", "삭제 성공");

        }else {
            redirectAttributes.addFlashAttribute("error", "삭제 실패");
        }
        return "redirect:/admin/users";

    }

}
