package com.study.pr06vmapi;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ApiController {
    private Product product;
    @Getter
    private List<Product> productList = new ArrayList<>();

    @PostMapping("/add")
    public List<Product> add(@RequestBody Map<String, Object> requestBody) {
        String name = requestBody.get("name").toString();
        int price = Integer.parseInt(requestBody.get("price").toString());
        String limit_date = requestBody.get("limit_date").toString();

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setLimit_date(limit_date);
        productList.add(product);

        return productList;
    }

//    @PostMapping("/edit")
//    public ResponseEntity<Product> edit(@RequestBody Product product) {
//        for(Product product: productList) {
//            if(product.getName().equals(name)) {
//                product.setPrice(price);
//                product.setLimit_date(limit_date);
//                break;
//            }
//        }
//        model.addAttribute("productList", productList);
//
//        return "redirect:/";
//    }

    @GetMapping("/delete")
    public String delete(@RequestParam String name, Model model) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                iterator.remove();
                break;
            }
        }
        model.addAttribute("productList", productList);
        return "redirect:/";
    }
}

