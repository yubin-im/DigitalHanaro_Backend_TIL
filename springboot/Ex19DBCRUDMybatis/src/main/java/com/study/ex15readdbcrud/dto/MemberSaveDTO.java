package com.study.ex15readdbcrud.dto;

import com.study.ex15readdbcrud.entity.MemberEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberSaveDTO {
    private Long id;
    private String userId;
    private String userPw;
    private String userName;
    private String userRole;
    private String userAddress;  // 엔티티에 없는 변수도 추가 가능
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    // DTO를 save용 Entity로 변환해주는 메소드
    public MemberEntity toSaveEntity() {
        return MemberEntity.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userRole(userRole)
                .joinDate(joinDate)
                .build();
    }

    // DTO를 update용 Entity로 변환해주는 메소드
    public MemberEntity toUpdateEntity() {
        return MemberEntity.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userRole(userRole)
                .joinDate(joinDate)
                .build();
    }
}
