package com.study.ex05staticweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
//    @ResponseBody  // 문자열로 응답
    public String main() {
        return "index.html";
    }
}
