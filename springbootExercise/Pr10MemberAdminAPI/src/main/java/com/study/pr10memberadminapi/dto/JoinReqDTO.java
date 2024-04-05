package com.study.pr10memberadminapi.dto;

import lombok.Data;

@Data
public class JoinReqDTO {
    private String inputName;
    private String inputEmail;
    private String inputPw;
}