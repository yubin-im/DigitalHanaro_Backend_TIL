package com.study.pr03vm;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class Product {
    private String name; // 상품명
    private int price; // 가격
    private String limit_date; // 유통기한
}