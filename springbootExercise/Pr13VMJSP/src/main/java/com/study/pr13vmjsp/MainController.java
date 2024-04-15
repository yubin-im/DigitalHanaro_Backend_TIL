package com.study.pr13vmjsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class MainController {
    private List<Product> productList = new ArrayList<>();

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("productList", productList);
        return "productList";
    }

    @PostMapping("/add-action")
    public String add(@RequestParam String name,
                      @RequestParam int price,
                      @RequestParam LocalDate limitDate,
                      Model model) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setLimit_date(limit_date);

        productList.add(product);
        model.addAttribute("productList", productList);

        return "redirect:/";
    }


    @PostMapping("/edit-action")
    public String edit(@RequestParam String name,
                       @RequestParam int price,
                       @RequestParam String limit_date,
                       Model model) {
        for(Product product: productList) {
            if(product.getName().equals(name)) {
                product.setPrice(price);
                product.setLimit_date(limit_date);
                break;
            }
        }
        model.addAttribute("productList", productList);

        return "redirect:/";
    }

    @GetMapping("/edit")
    public String viewEditForm(@RequestParam String name, Model model) {
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

    @GetMapping("/delete-action")
    public String delete(@RequestParam int id, Model model) {
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
