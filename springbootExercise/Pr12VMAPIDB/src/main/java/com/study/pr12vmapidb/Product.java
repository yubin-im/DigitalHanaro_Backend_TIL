package com.study.pr12vmapidb;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name="product")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "limit_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate limitDate;

    // Entity -> DTO 변환 메소드
    public ProductDTO toProductDTO() {
        return ProductDTO.builder()
                .id(id)
                .name(name)
                .price(price)
                .limitDate(limitDate)
                .build();
    }

    // 상품 수정
    public void updateProduct(String name, int price, LocalDate limitDate) {
        this.name = name;
        this.price = price;
        this.limitDate = limitDate;
    }
}

