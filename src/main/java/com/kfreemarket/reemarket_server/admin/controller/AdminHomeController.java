package com.kfreemarket.reemarket_server.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminHomeController {

    @GetMapping("/")
    public String Login(Model model) {
        return "index";
    }

    @GetMapping("/admin")
    public String Admin(Model model) {
        return "dashboard";
    }



}
