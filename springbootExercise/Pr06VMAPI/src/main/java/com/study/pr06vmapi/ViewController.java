package com.study.pr06vmapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class ViewController {
    final private Product product;
    final ProductRepository repo;

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

    // 수정할 상품 불러오기
    @GetMapping("/edit/{index}")
    public String viewEditForm(@PathVariable int index, Model model) {
        Product product = repo.productList.get(index);

        model.addAttribute("index", index);
        model.addAttribute("product", product);
        return "editProductForm";
    }
}
