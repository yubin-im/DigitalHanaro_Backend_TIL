package com.study.pr12vmapidb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class ProductApiController {
    final ProductRepository productRepository;

    // 상품 전체 조회
    @PostMapping("/")
    @ResponseBody
    public List<Product> main() {
        List<Product> productList = productRepository.findAll();

        return productList;
    }

//    // 상품 추가
//    @PostMapping("/add")
//    public List<Product> add(@RequestBody AddReqDTO addReqDTO) {
//        Product product = Product.builder()
//                .name(addReqDTO.getName())
//                .price(addReqDTO.getPrice())
//                .limitDate(addReqDTO.getLimitDate())
//                .build();
//        repo.productList.add(product);
//
//        System.out.println("상품리스트: " + repo.productList);
//        return repo.productList;
//    }

    // 수정할 상품 불러오기
    @GetMapping("/edit")
    public String viewEditForm(@RequestParam Long id, Model model) {
        Product product = productRepository.findById(id).orElse(null);

        model.addAttribute("product", product);
        return "editProductForm";
    }

//    // 상품 수정
//    @PostMapping("/edit-action")
//    public List<Product> updateProduct(@RequestBody ProductDTO productDTO) {
//        Product product = repo.productList.get(productDTO.getIndex());
//
//        product.updateProduct(productDTO.getName(), productDTO.getPrice(), productDTO.getLimitDate());
//
//        repo.productList.set(productDTO.getIndex(), product);
//
//        System.out.println("수정된 상품: " + repo.productList);
//        return repo.productList;
//    }
//
//    // 상품 삭제
//    @DeleteMapping("/delete")
//    public List<Product> delete(@RequestBody Map<String, String> nameMap) {
//        String name = nameMap.get("name");
//
//        Iterator<Product> iterator = repo.productList.iterator();
//        while (iterator.hasNext()) {
//            Product product = iterator.next();
//            if (product.getName().equals(name)) {
//                iterator.remove();
//                break;
//            }
//        }
//
//        return repo.productList;
//    }
}
