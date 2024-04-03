package com.study.pr06vmapi;

import lombok.Data;

@Data
public class AddReqDTO {
    private String name;
    private int price;
    private String limit_date;
}
