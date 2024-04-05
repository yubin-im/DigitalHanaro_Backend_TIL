package com.study.pr10memberadminapi;

import lombok.Data;

@Data
public class JoinReqDTO {
    private String inputName;
    private String inputEmail;
    private String inputPw;
}