package com.study.pr08loginjoinapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ApiController {

    private List<Member> memberList = new ArrayList<>();

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

    // 회원가입
    @PostMapping("/join")
    @ResponseBody
    public List<Member> join(@RequestBody JoinReqDTO joinReqDTO) {
        Member member = Member.builder()
                .username(joinReqDTO.getInputName())
                .email(joinReqDTO.getInputEmail())
                .password(joinReqDTO.getInputPw())
                .joindate(LocalDate.now())
                .build();

        memberList.add(member);
        return memberList;
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
