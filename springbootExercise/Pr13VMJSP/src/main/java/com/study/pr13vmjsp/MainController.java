package com.study.pr13vmjsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private List<Product> productList = new ArrayList<>();

    // 상품 전체 조회
    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("productList", productList);

        return "productList";
    }

    // 상품 추가 기능
    @PostMapping("/add-action")
    public String add(@RequestParam String name,
                      @RequestParam int price,
                      @RequestParam LocalDate limitDate,
                      Model model) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .limitDate(limitDate)
                .build();
        productList.add(product);

        model.addAttribute("productList", productList);
        return "redirect:/";
    }


    // 상품 수정 기능
    @PostMapping("/edit-action")
    public String edit(@RequestParam int id,
                       @RequestParam String name,
                       @RequestParam int price,
                       @RequestParam LocalDate limitDate,
                       Model model) {
        Product product = productList.get(id);
        product.updateProduct(name, price, limitDate);
        productList.set(id, product);

        model.addAttribute("productList", productList);
        return "redirect:/";
    }

    // 상품 상세 조회
    @GetMapping("/edit")
    public String viewEditForm(@RequestParam int id, Model model) {
        Product foundProduct = productList.get(id);

        model.addAttribute("product", foundProduct);
        return "editProductForm";
    }

    // 상품 삭제 기능
    @GetMapping("/delete-action")
    public String delete(@RequestParam int id, Model model) {
        productList.remove(id);

        model.addAttribute("productList", productList);
        return "redirect:/";
    }
}
