package com.study.ex12h2dbtest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String main(Model model) {
        // 테이블 값(row) 추가 (save와 new 사용)
        memberRepository.save(new MemberEntity(Long.valueOf(1), "hong", "1234", "홍길동", "ROLE_USER", LocalDate.parse("2023-01-01")));
        memberRepository.save(new MemberEntity(Long.valueOf(2), "tom", "1234", "톰아저씨", "ROLE_USER", LocalDate.parse("2023-02-01")));
        memberRepository.save(new MemberEntity(Long.valueOf(3), "admin", "1234", "관리자", "ROLE_ADMIN", LocalDate.parse("2023-03-01")));

        //테이블의 전체 값 리스트에 추가 (findAll 사용)
        List<MemberEntity> list = memberRepository.findAll();

        for (MemberEntity m: list) {
            System.out.println(m.getUserName());
        }

        model.addAttribute("list", list);
        return "index";
    }
}
