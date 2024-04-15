package com.study.pr12vmapidb;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class AddReqDTO {
    private String name;
    private int price;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate limitDate;
}
