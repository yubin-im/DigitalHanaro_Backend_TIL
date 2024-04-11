package com.study.ex15readdbcrud.dto;

import com.study.ex15readdbcrud.entity.MemberEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberJoinDTO {
    private Long id;

    @Size(min = 4, max = 20, message = "userId는 4자이상 20자 이하입니다.")
    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    private String userId;

    @Size(min = 4, max = 20, message = "암호는 4자이상 20자 이하입니다.")
    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    private String userPw;

    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    private String userName;

    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
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
