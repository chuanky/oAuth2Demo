package com.example.oAuth2Demo.controller;

import com.example.oAuth2Demo.model.User;
import com.example.oAuth2Demo.repository.UserRepository;
import com.example.oAuth2Demo.service.JwtService;
import com.example.oAuth2Demo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Chuanqi Shi
 * @date 2021/Apr/28
 */
@RestController
public class MainController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    UserRepository repo;

    @GetMapping("/")
    public String hello(@RequestHeader("Authorization") String content) {
        String token = content.substring(7);
        return "Hello " + jwtService.extractUsername(token) + " " + jwtService.extractUserId(token);
    }

    @PostMapping("/user")
    public String secure(@RequestParam String username) {
        Optional<User> user = repo.findById(username);
        return user.map(value -> "UserId: " + value.getId()).orElseGet(() -> "Cannot find user: " + username);
    }

    @PostMapping("/private")
    public String own(@RequestParam String text) throws Exception {
        String result = "hello " + text;
        throw new Exception("test");
//        return result;
    }

    @PostMapping(path = "/createAuthToken")
    public String createAuthToken(@RequestParam String username,
                                  @RequestParam String password) throws BadCredentialsException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("invalid username or password");
        }

        final UserDetails userDetails = userDetailService.loadUserByUsername(username);

        return jwtService.generateToken(userDetails);
    }
}
