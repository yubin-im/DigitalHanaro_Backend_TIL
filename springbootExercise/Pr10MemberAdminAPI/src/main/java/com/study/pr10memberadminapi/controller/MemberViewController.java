package com.study.pr10memberadminapi.controller;

import com.study.pr10memberadminapi.entity.Member;
import com.study.pr10memberadminapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberViewController {
    final private Member member;
    final MemberRepository repo;

    // 메인 출력
    @GetMapping("/")
    public String main() {
        return "login-form";
    }

    // 회원가입 폼 출력
    @GetMapping("/join")
    public String viewJoin() {
        return "join-form";
    }

    // 관리자페이지 - 전체 회원목록 출력
    @GetMapping("/admin")
    public String viewAdmin(Model model) {
        model.addAttribute("memberList", repo.memberList);
        return "admin-form";
    }

    // 관리자 페이지 - 회원목록 상세 출력
    // localhost:8080/update-form?index=1
    @GetMapping("/update-form")
    public String viewUpdateForm(@RequestParam int index, Model model) {
        model.addAttribute("index", index);

        Member member = repo.memberList.get(index-1);
        model.addAttribute("member", member);
        return "update-form";
    }
}
