package com.study.pr06vmapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {
    @Autowired
    private ApiController apiController;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("productList", apiController.getProductList());
        return "productList";
    }

    @GetMapping("/add")
    public String viewAddForm() {
        return "addProductForm";
    }

    @GetMapping("/edit")
    public String viewEditForm(@RequestParam String name, Model model) {
        List<Product> productList = (List<Product>) model.getAttribute("productList");
        Product foundProduct = null;

        for(Product product: productList) {
            if(product.getName().equals(name)) {
                foundProduct = product;
                break;
            }
        }
        model.addAttribute("product", foundProduct);

        return "editProductForm";
    }
}
