package com.study.pr06vmapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RequiredArgsConstructor
@RestController
public class ApiController {
    final ProductRepository repo;

    // 상품 전체 조회
    @PostMapping("/")
    public List<Product> main() {
        return repo.productList;
    }

    // 상품 추가
    @PostMapping("/add")
    public List<Product> add(@RequestBody AddReqDTO addReqDTO) {
        Product product = Product.builder()
                .name(addReqDTO.getName())
                .price(addReqDTO.getPrice())
                .limit_date(addReqDTO.getLimit_date())
                .build();
        repo.productList.add(product);

        System.out.println("상품리스트: " + repo.productList);
        return repo.productList;
    }

    // 상품 수정
    @PostMapping("/edit-action")
    public List<Product> updateProduct(@RequestBody ProductDTO productDTO) {
        Product product = repo.productList.get(productDTO.getIndex());

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setLimit_date(productDTO.getLimit_date());

        repo.productList.set(productDTO.getIndex(), product);

        System.out.println("수정된 상품: " + repo.productList);
        return repo.productList;
    }

    // 상품 삭제
    @DeleteMapping("/delete")
    public List<Product> delete(@RequestBody Map<String, String> nameMap) {
        String name = nameMap.get("name");

        Iterator<Product> iterator = repo.productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                iterator.remove();
                break;
            }
        }

        return repo.productList;
    }
}

