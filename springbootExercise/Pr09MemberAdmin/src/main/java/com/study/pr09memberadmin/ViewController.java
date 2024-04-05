package com.study.pr09memberadmin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ViewController {
    final private Member member;

    // 메인 출력
    @GetMapping("/")
    public String main() {
        return "login-form";
    }

    // 회원가입 폼 출력
    @GetMapping("/join")
    public String viewJoin() {
        return "join-form";
    }

}
