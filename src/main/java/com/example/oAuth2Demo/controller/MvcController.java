package com.example.oAuth2Demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Chuanqi Shi
 * @date 2021/Jul/11
 */
@Controller
public class MvcController {
    @GetMapping("/greeting")
    public String greeting() {
        return "greeting";
    }
}
