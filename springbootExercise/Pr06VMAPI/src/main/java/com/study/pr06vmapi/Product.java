package com.study.pr06vmapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
public class Product {
    private String name; // 상품명
    private int price; // 가격
    private String limit_date; // 유통기한
}