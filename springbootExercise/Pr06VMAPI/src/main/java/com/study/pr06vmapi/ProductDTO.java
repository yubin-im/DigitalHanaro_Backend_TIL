package com.study.pr06vmapi;

import lombok.Data;

@Data
public class ProductDTO {
    private int index;
    private String name; // 상품명
    private int price; // 가격
    private String limit_date; // 유통기한
}
