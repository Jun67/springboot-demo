package com.bailiban.springboot.controller;

import com.bailiban.springboot.model.User;
import com.bailiban.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(User user, HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/user/home";
        }
        if (user.getName() == null || user.getPassword() == null) {
            return "login";
        }
        User u = userService.login(user);
        if (u != null) {
            session.setAttribute("user", u);
            return "redirect:/user/home";
        }
        return "login";
    }

    @RequestMapping("home")
    public String home() {
        return "home";
    }

    @GetMapping("update")
    public String update() {
        return "update";
    }

    @PostMapping("update")
    public String update(@Validated User user, HttpSession session) {
        System.out.println(user);
        userService.update(user);
        session.setAttribute("user", userService.get(user.getId()));
        return "redirect:/user/home";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("register")
    public String register(@Validated User user) {
        userService.insert(user);
        return "redirect:/user/login";
    }
}
