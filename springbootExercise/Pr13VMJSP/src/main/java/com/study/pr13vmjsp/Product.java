package com.study.pr13vmjsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private String name; // 상품명
    private int price; // 가격
    private LocalDate limitDate; // 유통기한
    private int id; // 번호

    // 상품 수정
    public void updateProduct(String name, int price, LocalDate limitDate) {
        this.name = name;
        this.price = price;
        this.limitDate = limitDate;
    }
}
