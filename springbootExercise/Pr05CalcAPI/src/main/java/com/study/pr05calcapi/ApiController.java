package com.study.pr05calcapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {
    private Calc calc;

    @Autowired
    public ApiController(Calc calc) {
        this.calc = calc;
    }

    @PostMapping("/calculate")
    public Map<String, Double> calculate(@RequestBody Map<String, Object> requestBody) {
        double number1 = Double.parseDouble(requestBody.get("number1").toString());
        double number2 = Double.parseDouble(requestBody.get("number2").toString());
        String operator = requestBody.get("operator").toString();

        switch (operator) {
            case "+":
                calc.setResult(number1 + number2);
                break;
            case "-":
                calc.setResult(number1 - number2);
                break;
            case "*":
                calc.setResult(number1 * number2);
                break;
            case "/":
                calc.setResult(number1 / number2);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("result", calc.getResult());
        return responseBody;
    }
}

