package com.study.pr09memberadmin;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class Member {
    private String username;
    private String password;
    private String email;
    private LocalDate joindate;
}
