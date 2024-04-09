package com.study.ex15readdbcrud.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

// html입력폼 <-> DTO <-> DAO(Entity) <-> XML(Repo클래스) <-> DB

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
    private Long id;
    private String userId;
    private String userPw;
    private String userName;
    private String userRole;
    private String userAddress;  // 엔티티에 없는 변수도 추가 가능
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;
}
