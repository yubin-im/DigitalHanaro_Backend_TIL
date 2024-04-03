package com.study.pr06vmapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    // 메인 폼 출력
    @GetMapping("/")
    public String viewMain() {
        return "productList";
    }

    // 상품 추가 폼 출력
    @GetMapping("/add")
    public String viewAddForm() {
        return "addProductForm";
    }
}
