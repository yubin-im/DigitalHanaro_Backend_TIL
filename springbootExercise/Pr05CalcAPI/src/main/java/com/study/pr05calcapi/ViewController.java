package com.study.pr05calcapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    private Calc calc;

    @Autowired
    public ViewController(Calc calc) {
        this.calc = calc;
    }

    // 메인 페이지 뷰
    @GetMapping("/")
    public String main() {
        return "main";
    }
}
