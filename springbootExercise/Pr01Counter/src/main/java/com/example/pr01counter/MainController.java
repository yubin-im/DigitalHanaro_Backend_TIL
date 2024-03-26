package com.example.pr01counter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private Counter counter;

    @Autowired
    public MainController(Counter counter) {
        this.counter = new Counter();
    }

    @GetMapping("")
    public String main(Model model) {
        model.addAttribute("counter", counter);
        return "main";
    }

    @GetMapping("plus")
    public String plus(Model model) {
        counter.plus();
        return "redirect:";
    }

    @GetMapping("minus")
    public String minus(Model model) {
        counter.minus();
        return "redirect:";
    }
}
