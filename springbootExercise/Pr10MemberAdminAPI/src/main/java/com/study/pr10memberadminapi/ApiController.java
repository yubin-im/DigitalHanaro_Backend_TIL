package com.study.pr10memberadminapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ApiController {
    final private Member member;
    final MemberRepository repo;

    // 로그인
    @PostMapping("/")
    public String login(@RequestParam("inputName") String inputName,
                        @RequestParam("inputPw") String inputPw,
                        Model model) {
        String message = "로그인 실패!";

        for(Member member: repo.memberList) {
            if(member.getUsername().equals(inputName) && member.getPassword().equals(inputPw)) {
                message = "로그인 성공!";
                break;
            }
        }

        model.addAttribute("message", message);
        return "login-form";
    }

    // 회원가입
    @PostMapping("/join")
    public String join(@RequestParam("inputName") String inputName,
                       @RequestParam("inputEmail") String inputEmail,
                       @RequestParam("inputPw") String inputPw,
                       Model model) {
        Member member = Member.builder()
                .username(inputName)
                .email(inputEmail)
                .password(inputPw)
                .joindate(LocalDate.now())
                .build();
        repo.memberList.add(member);

        model.addAttribute("memberList", repo.memberList);
        System.out.println("가입한 회원 정보: " + repo.memberList);
        return "redirect:/";
    }

    @PostMapping("/check_duplicate")
    @ResponseBody
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
    @ResponseBody
    public String updateMember(@RequestParam int index,
                               @RequestParam String inputName,
                               @RequestParam String inputPw,
                               @RequestParam String inputEmail,
                               @RequestParam LocalDate inputJoindate) {
        Member member = repo.memberList.get(index-1);
        member.setUsername(inputName);
        member.setPassword(inputPw);
        member.setEmail(inputEmail);
        member.setJoindate(inputJoindate);

        repo.memberList.set(index-1, member);
        System.out.println("수정된 회원 정보: " + repo.memberList);
        return "<script>alert('회원 정보가 수정되었습니다.'); location.href='/admin';</script>";
    }

    // 관리자 페이지 - 회원목록 삭제
    // localhost:8080/deleteProduct?index=1
    @GetMapping("/deleteProduct")
    @ResponseBody
    public String deleteProduct(@RequestParam int index){
        repo.memberList.remove(index-1);
        return "<script>alert('회원이 삭제되었습니다.'); location.href='/admin';</script>";
    }
}


