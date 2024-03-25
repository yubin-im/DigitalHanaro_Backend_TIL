package com.study.ex02springdi;

import org.springframework.stereotype.Component;

// 스프링에서 빈 생성시 POJO 클래스를 이용한다.
// POJO: POJO란 EJB와 달리 순수한 자바 클래스
// getter/setter/생성자(constructor)만 추가해서 빈을 만든다.
@Component
public class Member {
    private String name = "이순신";

    // 기본 생성자
    public Member() {

    }

    // 매개변수 있는 생성자
    public Member(String name) {
        this.name = name;
    }

    // Getter/Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
