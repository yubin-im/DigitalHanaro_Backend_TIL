package com.study.pr08loginjoinapi;

import lombok.Data;

@Data
public class JoinReqDTO {
    private String inputName;
    private String inputEmail;
    private String inputPw;
}
