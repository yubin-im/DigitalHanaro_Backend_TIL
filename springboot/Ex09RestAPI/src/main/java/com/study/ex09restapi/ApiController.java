package com.study.ex09restapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController  // @RestController = @Controller + @ResponseBody
@RequestMapping("/api/v1")
public class ApiController {
    public static List<Member> memberList = new ArrayList<>();

    // URL: localhost:8080/api/v1/login
    @PostMapping("/login")
    public ResDTO login(@RequestBody ReqDTO reqDTO) {
        System.out.println(reqDTO.getUsername());
        System.out.println(reqDTO.getPassword());

        // 로그인 로직
        // reqDTO.username이 DB(리스트)에 있는지 확인
        boolean found = false;
        for(Member member: memberList) {
            if(member.getUsername().equals(reqDTO.getUsername())
            && member.getPassword().equals(reqDTO.getPassword())) {
                found = true;  // 로그인 처리, 세션 객체에 로그인 상태 저장
                break;
            }
        }

        ResDTO resDTO = new ResDTO();
        if (found == true) {
            resDTO.setStatus("ok");
            resDTO.setMessage("로그인 중입니다.");
        } else {
            resDTO.setStatus("fail");
            resDTO.setMessage("로그인 실패!");
        }

        return resDTO;
    }

    public void join() {

    }
}
