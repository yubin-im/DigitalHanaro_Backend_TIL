package com.study.pr06vmapi;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private String name; // 상품명
    private int price; // 가격
    private String limit_date; // 유통기한
}
