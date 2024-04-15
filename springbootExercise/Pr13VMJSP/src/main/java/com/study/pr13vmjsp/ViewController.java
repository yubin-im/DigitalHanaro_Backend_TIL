package com.study.pr13vmjsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    // 상품 추가 폼 출력
    @GetMapping("/add")
    public String viewAddForm() {
        return "addProductForm";
    }
}
