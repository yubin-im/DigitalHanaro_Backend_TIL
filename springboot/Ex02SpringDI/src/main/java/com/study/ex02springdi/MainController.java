package com.study.ex02springdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller: HTTP 요청을 처리하는 컨트롤 클래스 위에 붙인다.
// GET/POST/PUT/DELETE 요청 등을 처리한다.
@Controller
public class MainController {
    @GetMapping("")  // HTTP GET 요청을 처리하는 함수에 붙인다. 내부적으로 메소드는 Servlet으로 동작한다.
    @ResponseBody  // 응답을 문자열(JSON)로 응답한다는 의미
    public String main() {
        return "스프링부트 웹 애플리케이션!";
//        return "{ name: 'Hong', age: 20 }";
    }

    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "테스트입니다.";
    }

    // 스프링 빈을 주입받는 방법
    // 1. 필드 주입
    @Autowired
    private Member member1;

    @GetMapping("field")
    @ResponseBody
    public String field() {
        System.out.println();
        return "field() 호출됨 - " + member1.getName();
    }

    // 2. setter 주입
    private Member member3;

    @Autowired
    public void setMember(Member member) {
        this.member3 = member;
    }

    @GetMapping("setter")
    @ResponseBody
    public String setter() {
        return "setter() 호출됨: " + member3.getName();
    }

    // 3. 생성자(constructor) 주입 - 추천 방법
    private final Member member4;

    @Autowired
    public MainController(Member member) {
        this.member4 = member;
    }

    @GetMapping("constructor")
    @ResponseBody
    public String constructor() {
        return "constructor() 호출됨: " + member4.getName();
    }
}
