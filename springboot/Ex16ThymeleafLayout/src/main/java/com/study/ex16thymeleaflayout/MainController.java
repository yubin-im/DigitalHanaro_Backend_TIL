package com.study.ex16thymeleaflayout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main() {
        return "first";
    }

    @GetMapping("/second")
    public String second() {
        return "second";
    }
}
