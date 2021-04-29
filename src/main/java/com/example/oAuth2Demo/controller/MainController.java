package com.example.oAuth2Demo.controller;

import com.example.oAuth2Demo.model.User;
import com.example.oAuth2Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Chuanqi Shi
 * @date 2021/Apr/28
 */
@RestController
public class MainController {
    @Autowired
    UserRepository repo;

    @GetMapping("/")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/user")
    public String secure(@RequestParam String username) {
        Optional<User> user = repo.findById(username);
        return user.map(value -> "UserId: " + value.getId()).orElseGet(() -> "Cannot find user: " + username);
    }

    @PostMapping("/private")
    public String own(@RequestParam String text) {
        String result = "hello " + text;
        return result;
    }
}
