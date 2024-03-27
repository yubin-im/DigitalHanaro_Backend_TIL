package com.study.ex09restapi;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class Member {
    private String username;
    private String password;
    private String email;
    private LocalDate joindate;

}
