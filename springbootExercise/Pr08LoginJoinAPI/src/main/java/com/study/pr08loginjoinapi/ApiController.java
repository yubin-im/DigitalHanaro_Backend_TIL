package com.study.pr08loginjoinapi;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {
    private List<Member> memberList = new ArrayList<>();

    // 로그인
    @PostMapping("/")
    public Map<String, String> login(@RequestBody LoginReqDTO loginReqDTO) {
        String message = "로그인 실패!";
        String inputName = loginReqDTO.getInputName();
        String inputPw = loginReqDTO.getInputPw();

        for(Member member: memberList) {
            if(member.getUsername().equals(inputName) &&
                    member.getPassword().equals(inputPw)) {
                message = "로그인 성공!";
                break;
            }
        }

        Map<String, String> loginResMap = new HashMap<>();
        loginResMap.put("message", message);

        return loginResMap;
    }

    // 회원가입
    @PostMapping("/join")
    public List<Member> join(@RequestBody JoinReqDTO joinReqDTO) {
        Member member = Member.builder()
                .username(joinReqDTO.getInputName())
                .email(joinReqDTO.getInputEmail())
                .password(joinReqDTO.getInputPw())
                .joindate(LocalDate.now())
                .build();

        memberList.add(member);
        System.out.println("회원 리스트: " + memberList);
        return memberList;
    }

    @PostMapping("/check_duplicate")
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
