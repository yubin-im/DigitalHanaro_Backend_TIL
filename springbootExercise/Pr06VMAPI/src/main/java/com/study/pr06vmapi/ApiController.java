package com.study.pr06vmapi;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ApiController {
    private List<Product> productList = new ArrayList<>();

    // 상품 전체 조회
    @GetMapping("/")
    public List<Product> main() {
        return productList;
    }

    // 상품 추가
    @PostMapping("/add")
    public List<Product> add(@RequestBody AddReqDTO addReqDTO) {
        Product product = Product.builder()
                .name(addReqDTO.getName())
                .price(addReqDTO.getPrice())
                .limit_date(addReqDTO.getLimit_date())
                .build();
        productList.add(product);

        return productList;
    }

    // 상품 수정
    @PostMapping("/edit")
    public List<Product> edit(@RequestBody ProductDTO productDTO) {
        String name = productDTO.getName();
        int price = productDTO.getPrice();
        String limit_date = productDTO.getLimit_date();

        for(Product product: productList) {
            if(product.getName().equals(name)) {
                product.setPrice(price);
                product.setLimit_date(limit_date);
                break;
            }
        }
        return productList;
    }

    // 수정할 상품 불러오기
    @GetMapping("/edit")
    public ProductDTO viewEditForm(@RequestBody Map<String, String> nameMap) {
        String name = nameMap.get("name");
        ProductDTO productDTO = null;

        for(Product product: productList) {
            if(product.getName().equals(name)) {
                productDTO = new ProductDTO(product.getName(), product.getPrice(), product.getLimit_date());
                break;
            }
        }

        return productDTO;
    }

    // 상품 삭제
    @DeleteMapping("/delete")
    public List<Product> delete(@RequestBody Map<String, String> nameMap) {
        String name = nameMap.get("name");

        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                iterator.remove();
                break;
            }
        }

        return productList;
    }
}

