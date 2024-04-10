package com.study.pr06vmapi;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private String name; // 상품명
    private int price; // 가격
    private String limit_date; // 유통기한
}