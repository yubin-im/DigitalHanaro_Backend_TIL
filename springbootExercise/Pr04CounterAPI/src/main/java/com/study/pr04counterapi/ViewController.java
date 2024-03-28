package com.study.pr04counterapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    private Counter counter;

    @Autowired
    public ViewController(Counter counter) {
        this.counter = counter;
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("counter", counter);
        return "main";
    }
}
