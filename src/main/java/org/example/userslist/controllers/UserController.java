package org.example.userslist.controllers;

import org.example.userslist.model.User;
import org.example.userslist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/users")
    public String addUser(User user, Model model){
        model.addAttribute("user", service.addUser(user));
        model.addAttribute("list", List.of());
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("list", service.getUsers());
        return "/users";
    }
}
