package com.study.ex28jwt.dto;

import com.study.ex28jwt.enumeration.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String email;
    private String password;
    private UserRole userRole;
}
