package com.example.pr11vmdb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    final ProductRepository productRepository;

    // 전체 상품 출력
    @GetMapping("/")
    public String main(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);

        return "productList";
    }

    // 상품 추가 폼 출력
    @GetMapping("/add")
    public String viewAddForm() {
        return "addProductForm";
    }

    // 상품 추가
    @PostMapping("/add-action")
    public String addProduct(@RequestParam String name,
                             @RequestParam int price,
                             @RequestParam LocalDate limitDate) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .limitDate(limitDate)
                .build();
        productRepository.save(product);

        return "redirect:/";
    }

    // 상품 수정 폼 출력
    @GetMapping("/edit")
    public String viewUpdateForm(@RequestParam Long id, Model model) {
        Product product = productRepository.findById(id).orElse(null);
        model.addAttribute("product", product);

        return "editProductForm";
    }

    // 상품 수정
    @PostMapping("/edit-action")
    public String editProduct(@RequestParam Long id,
                              @RequestParam String name,
                              @RequestParam int price,
                              @RequestParam LocalDate limitDate) {
        Product product = productRepository.findById(id).orElse(null);
        product.setName(name);
        product.setPrice(price);
        product.setLimitDate(limitDate);
        productRepository.save(product);

        return "redirect:/";
    }

    // 상품 삭제
    @GetMapping("/delete-action")
    public String deleteProduct(@RequestParam Long id) {
        Product product = productRepository.findById(id).orElse(null);
        productRepository.delete(product);

        return "redirect:/";
    }
}
