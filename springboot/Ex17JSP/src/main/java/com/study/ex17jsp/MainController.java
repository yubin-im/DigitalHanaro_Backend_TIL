package com.study.ex17jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(){
        return "ex01"; //ex01.jsp 응답함.
    }
}
