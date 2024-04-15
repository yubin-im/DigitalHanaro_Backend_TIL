package com.study.pr12vmapidb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductViewController {

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

    // 상품 수정 폼 출력
    @GetMapping("/edit")
    public String viewEditForm() {
        return "editProductForm";
    }
}

