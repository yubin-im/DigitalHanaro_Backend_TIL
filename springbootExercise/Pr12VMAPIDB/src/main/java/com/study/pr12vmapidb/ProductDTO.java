package com.study.pr12vmapidb;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private int price;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate limitDate;

    // DTO-> Entity 변환 메소드
    public Product toProductEntity() {
        return Product.builder()
                .id(id)
                .name(name)
                .price(price)
                .limitDate(limitDate)
                .build();
    }
}