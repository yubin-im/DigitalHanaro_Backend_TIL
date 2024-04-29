package com.study.ex28jwt.controller;

import com.study.ex28jwt.config.JwtUtil;
import com.study.ex28jwt.dto.UserDto;
import com.study.ex28jwt.dto.UserRequestDto;
import com.study.ex28jwt.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class ApiController {
    private final UserServiceImpl userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public UserDto createUser(UserRequestDto userRequest) {

        return userService.createUser(userRequest);
    }

    @GetMapping("/my")
    public UserDto findUser(Authentication authentication) {
        if (authentication == null) {
            throw new BadCredentialsException("회원 정보를 찾을 수 없습니다.");
        }
        return userService.findUser(authentication.getName());
    }

    @GetMapping("/admin")
    @PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
    public List<UserDto> findAllUser() {
        return userService.findAll();
    }

    @PostMapping("/login")
    public String login(UserRequestDto userRequest)  {
        UserDto users = userService.findByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword());
        return jwtUtil.createToken(users.getEmail(), Arrays.asList(users.getUserRole().getValue()));
    }
}
