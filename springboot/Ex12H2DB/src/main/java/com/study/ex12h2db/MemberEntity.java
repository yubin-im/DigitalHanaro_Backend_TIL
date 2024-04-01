package com.study.ex12h2db;

//데이타 모델링 클래스(데이타를 담고 있는)의 종류
//1. DTO 클래스 : Data Transfer Object, 데이타가 자주 바뀜. 로직(코드) 포함 안됨.
//             : 다른 계층간에 데이타 전송시 사용.
//2. VO 클래스 : View Object, 데이타가 안바뀜. 로직이 포함됨.
//            : 바뀌지 않는 데이타 보관시 사용.
//3. Entity 클래스 : DB 테이블 1:1 매칭, 로직(코드) 포함 안됨.

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

// @Entity: DB 테이블과 1:1로 매칭되는 JPA 클래스에 사용
// @Table: 클래스이름이 테이블이름으로 기본 설정되는데(여기선 MemberEntity로 생성),
// 테이블 이름을 바꿔주는데 사용
@Entity
@Table(name="member")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // bigint
    @Column(name="user_id")
    private String user_id;  // varchar
    @Column(name="user_pw")
    private String user_pw;
    @Column(name="user_name")
    private String user_name;
    @Column(name="user_role")
    private String user_role;
    @Column(name="joindate")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate joindate;
}
