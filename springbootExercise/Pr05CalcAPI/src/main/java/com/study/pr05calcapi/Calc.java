package com.study.pr05calcapi;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Calc {
    private double number1;
    private double number2;
    private String operator;
    private double result;
}

