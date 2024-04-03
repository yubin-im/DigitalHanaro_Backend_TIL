package com.study.pr06vmapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/add")
    public String viewAddForm() {
        return "addProductForm";
    }

}
