package com.study.pr10memberadminapi.controller;

import com.study.pr10memberadminapi.dto.JoinReqDTO;
import com.study.pr10memberadminapi.dto.LoginReqDTO;
import com.study.pr10memberadminapi.dto.UpdateReqDTO;
import com.study.pr10memberadminapi.entity.Member;
import com.study.pr10memberadminapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    final private Member member;
    final MemberRepository repo;

    // 로그인 기능
    @PostMapping("/")
    public Map<String, String> login(@RequestBody LoginReqDTO loginReqDTO) {
        String message = "로그인 실패!";
        String inputName = loginReqDTO.getInputName();
        String inputPw = loginReqDTO.getInputPw();

        for(Member member: repo.memberList) {
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

    // 회원가입 기능
    @PostMapping("/join")
    public List<Member> join(@RequestBody JoinReqDTO joinReqDTO) {
        Member member = Member.builder()
                .username(joinReqDTO.getInputName())
                .email(joinReqDTO.getInputEmail())
                .password(joinReqDTO.getInputPw())
                .joindate(LocalDate.now())
                .build();

        repo.memberList.add(member);
        System.out.println("회원 리스트: " + repo.memberList);
        return repo.memberList;
    }

    // 아이디 중복 확인
    @PostMapping("/check_duplicate")
    public Map<String, Boolean> checkDuplicate(@RequestBody Map<String, String> requestBody) {
        String inputName = requestBody.get("inputName");
        boolean duplicate = false;

        for(Member member: repo.memberList) {
            if(member.getUsername().equals(inputName)) {
                duplicate = true;
                break;
            }
        }

        Map<String, Boolean> response = new HashMap<>();
        response.put("duplicate", duplicate);
        return response;
    }

    // 관리자 페이지 - 회원목록 상세 수정
    @PostMapping("/update-action")
    public List<Member> updateMember(@RequestBody UpdateReqDTO updateReqDTO) {
        Member member = repo.memberList.get(updateReqDTO.getIndex()-1);
        member.setUsername(updateReqDTO.getInputName());
        member.setPassword(updateReqDTO.getInputPw());
        member.setEmail(updateReqDTO.getInputEmail());
        member.setJoindate(updateReqDTO.getInputJoindate());

        repo.memberList.set(updateReqDTO.getIndex()-1, member);
        System.out.println("수정된 회원 정보: " + repo.memberList);

        return repo.memberList;
    }

    // 관리자 페이지 - 회원목록 삭제
    // localhost:8080/deleteProduct?index=1
    @GetMapping("/deleteProduct")
    public List<Member> deleteProduct(@RequestParam int index){
        repo.memberList.remove(index-1);
        return repo.memberList;
    }
}


