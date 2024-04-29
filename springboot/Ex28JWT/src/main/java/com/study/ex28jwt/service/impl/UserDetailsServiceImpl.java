package com.study.ex28jwt.service.impl;

import com.study.ex28jwt.entity.UserRepository;
import com.study.ex28jwt.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public Users loadUserByUsername(String username) throws UsernameNotFoundException {
        Users usersEntity = Optional.ofNullable(
                userRepository.findByEmail(username)).orElseThrow(
                () -> new BadCredentialsException("비밀번호가 틀려서 회원 정보를 찾을 수 없습니다.")
        );

        return usersEntity;
    }
}
