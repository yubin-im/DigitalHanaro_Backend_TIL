package com.study.pr08loginjoinapi;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Builder
@Data
public class Member {
    private String username;
    private String password;
    private String email;
    private LocalDate joindate;
}