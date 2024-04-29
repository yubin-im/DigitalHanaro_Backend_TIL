package com.study.ex28jwt.service.impl;

import com.study.ex28jwt.dto.UserDto;
import com.study.ex28jwt.dto.UserRequestDto;
import com.study.ex28jwt.entity.UserRepository;
import com.study.ex28jwt.entity.Users;
import com.study.ex28jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserRequestDto dto) {
        Users saveEntity = Users.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .userRole(dto.getUserRole())
                .build();

        Users newEntity = userRepository.save(
                saveEntity
        );

        UserDto newDto = UserDto.builder()
                .id(newEntity.getId())
                .email(newEntity.getEmail())
                .password(newEntity.getPassword())
                .userRole(newEntity.getUserRole())
                .build();
        return newDto;
    }

    @Override
    public UserDto findUser(String email) {
        // ofNullable: null이 아니면 정상적인 값을 반환하고, null이면 empty를 반환한다.
        Users usersEntity = Optional.ofNullable(
                userRepository.findByEmail(email)).orElseThrow(
                        () -> new BadCredentialsException("비밀번호가 틀려서 회원 정보를 찾을 수 없습니다.")
        );

        UserDto dto = UserDto.builder()
                .id(usersEntity.getId())
                .email(usersEntity.getEmail())
                .password(usersEntity.getPassword())
                .userRole(usersEntity.getUserRole())
                .build();

        return dto;
    }

    @Override
    public UserDto findByEmailAndPassword(String email, String password) {
        Users usersEntity = Optional.ofNullable(
                userRepository.findByEmail(email)).orElseThrow(
                () -> new BadCredentialsException("이메일에 맞는 회원 정보를 찾을 수 없습니다.")
        );

        // DB에 있는 password를 복호화하여 입력된 password와 비교한다.
        if(bCryptPasswordEncoder.matches(password, usersEntity.getPassword()) == false) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        UserDto dto = UserDto.builder()
                .id(usersEntity.getId())
                .email(usersEntity.getEmail())
                .password(usersEntity.getPassword())
                .userRole(usersEntity.getUserRole())
                .build();

        return dto;
    }

    @Override
    public List<UserDto> findAll() {
        // 엔티티 클래스를 DTO 클래스로 바꾸어주는 stream 함수
        return userRepository.findAll().stream().map(
                e -> UserDto.builder()
                        .id(e.getId())
                        .email(e.getEmail())
                        .password(e.getPassword())
                        .userRole(e.getUserRole())
                        .build()
        ).collect(Collectors.toList());
    }
}
