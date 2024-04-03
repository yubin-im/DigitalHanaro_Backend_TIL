package com.study.pr08loginjoinapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Controller
public class ViewController {
    // 메인 출력
    @GetMapping("/")
    public String main() {
        return "login";
    }

    // 회원가입 폼 출력
    @GetMapping("/join")
    public String viewJoin() {
        return "join";
    }

}
