package com.study.pr02calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private Calc calc;

    @Autowired
    public MainController(Calc calc) {
        this.calc = new Calc();
    }

    @RequestMapping("")
    public String main() {
        return "main";
    }

    @PostMapping("calculate")
    public String calculate(@RequestParam("number1") double number1,
                            @RequestParam("number2") double number2,
                            @RequestParam("operator") String operator,
                            Model model) {

        switch (operator) {
            case "add":
                calc.setResult(number1 + number2);
                break;
            case "subtract":
                calc.setResult(number1 - number2);
                break;
            case "multiply":
                calc.setResult(number1 * number2);
                break;
            case "divide":
                calc.setResult(number1 / number2);
                break;
            default:
                model.addAttribute("result", "잘못된 연산자입니다.");
                return "main";
        }
        model.addAttribute("result", calc.getResult());
        return "main";
    }
}
