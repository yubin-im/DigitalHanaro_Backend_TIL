package com.study.ex27security01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String main() {
        return "스프링 시큐리티 웹입니다.";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }
}
