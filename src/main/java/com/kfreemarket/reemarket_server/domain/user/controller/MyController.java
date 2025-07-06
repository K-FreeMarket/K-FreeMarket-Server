package com.kfreemarket.reemarket_server.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

    @RequestMapping(value="/admin",method = RequestMethod.GET)
    public String hello(Model model){
    model.addAttribute("hello","서버입니다");
    return "/hello";
    }

}
