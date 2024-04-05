package com.study.pr10memberadminapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateReqDTO {
    private int index;
    private String inputName;
    private String inputPw;
    private String inputEmail;
    private LocalDate inputJoindate;

}
