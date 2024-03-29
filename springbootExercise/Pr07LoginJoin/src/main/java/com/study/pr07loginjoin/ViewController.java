package com.study.pr07loginjoin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {
    private Member member;
    private List<Member> memberList = new ArrayList<>();

    @GetMapping("/")
    public String main() {
        return "login";
    }

    @PostMapping("/")
    public String login(@RequestParam("inputName") String inputName,
                        @RequestParam("inputPw") String inputPw,
                        Model model) {
        String message = "로그인 실패!";

        for(Member member: memberList) {
            if(member.getUsername().equals(inputName) && member.getPassword().equals(inputPw)) {
                message = "로그인 성공!";
                break;
            }
        }

        model.addAttribute("message", message);
        return "login";
    }

    @GetMapping("/join")
    public String viewJoin() {
        return "join";
    }

    @PostMapping("/join")
    public String join(@RequestParam("inputName") String inputName,
                       @RequestParam("inputEmail") String inputEmail,
                       @RequestParam("inputPw") String inputPw,
                       Model model) {
        Member member = new Member();
        member.setUsername(inputName);
        member.setEmail(inputEmail);
        member.setPassword(inputPw);
        member.setJoindate(LocalDate.now());

        memberList.add(member);
        model.addAttribute("memberList", memberList);
        System.out.println("가입한 회원 정보: " + memberList);
        return "redirect:/";
    }
}
