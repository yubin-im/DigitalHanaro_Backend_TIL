package com.study.ex28jwt.service;

import com.study.ex28jwt.dto.UserDto;
import com.study.ex28jwt.dto.UserRequestDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserRequestDto dto);
    UserDto findUser(String email);
    UserDto findByEmailAndPassword(String email, String password);
    List<UserDto> findAll();
}
