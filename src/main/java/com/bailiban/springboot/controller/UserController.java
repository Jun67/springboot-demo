package com.bailiban.springboot.controller;

import com.bailiban.springboot.model.User;
import com.bailiban.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String home(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/user/login";
        }
        return "home";
    }
}
