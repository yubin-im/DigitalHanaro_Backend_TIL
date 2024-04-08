package com.study.ex17jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(){
        return "ex01"; //ex01.jsp 응답함.
    }

    // url: localhost:8080/ex/02
    @GetMapping("/ex/{no}")
    public String ex(@PathVariable String no) {
        return "ex" + no;
    }

}
