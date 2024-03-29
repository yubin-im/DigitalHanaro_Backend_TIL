package com.study.pr07loginjoin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    private Member member;
    private List<Member> memberList = new ArrayList<>();

    // 메인 출력
    @GetMapping("/")
    public String main() {
        return "login";
    }

    // 로그인
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

    // 회원가입 폼 출력
    @GetMapping("/join")
    public String viewJoin() {
        return "join";
    }

    // 회원가입
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

    @PostMapping("/check_duplicate")
    @ResponseBody
    public Map<String, Boolean> checkDuplicate(@RequestBody Map<String, String> requestBody) {
        String inputName = requestBody.get("inputName");
        boolean duplicate = false;

        for(Member member: memberList) {
            if(member.getUsername().equals(inputName)) {
                duplicate = true;
                break;
            }
        }

        Map<String, Boolean> response = new HashMap<>();
        response.put("duplicate", duplicate);
        return response;
    }
}
