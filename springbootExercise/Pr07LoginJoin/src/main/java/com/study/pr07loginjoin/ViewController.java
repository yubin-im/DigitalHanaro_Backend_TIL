package com.study.pr07loginjoin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ViewController {
    final Member member;

    @GetMapping("/")
    public String main() {
        return "login";
    }

    @GetMapping("/join-form")
    public String viewJoin() {
        return "join";
    }

    @PostMapping("/join-form")
    public String join() {
        return "redirect:/";
    }

}
