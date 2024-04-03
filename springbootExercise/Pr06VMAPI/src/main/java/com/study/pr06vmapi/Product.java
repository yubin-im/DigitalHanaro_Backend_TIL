package com.study.pr06vmapi;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {
    private String name; // 상품명
    private int price; // 가격
    private String limit_date; // 유통기한
}