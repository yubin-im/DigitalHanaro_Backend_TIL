package com.study.springboot;

import org.springframework.stereotype.Component;

// @Component : 클래스를 스프링 빈으로 등록한다. doScan() 함수에서 수행함.
@Component
public class PersonMan {
    private String name;
    private int age;

    // 기본생성자 : ObjectMapper(jackson,gson)를
    //   리플렉션을 이용한 객체생성을 할 때 사용함. 없으면 에러!
    public PersonMan() {

    }

    // 매개변수가 있는 생성자
    public PersonMan(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}