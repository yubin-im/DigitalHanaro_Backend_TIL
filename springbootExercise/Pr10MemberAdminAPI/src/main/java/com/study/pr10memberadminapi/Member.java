package com.study.pr10memberadminapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    private String username;
    private String password;
    private String email;
    private LocalDate joindate;
}
