package com.study.pr09memberadmin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MainController {
    final private Member member;
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

    // 관리자페이지 - 전체 회원목록 출력
    @GetMapping("/admin")
    public String viewAdmin(Model model) {
        model.addAttribute("memberList", memberList);
        return "admin-form";
    }

    // 관리자 페이지 - 회원목록 상세 출력
    // localhost:8080/update-form?index=1
    @GetMapping("/update-form")
    public String viewUpdateForm(@RequestParam int index, Model model) {
        model.addAttribute("index", index);

        Member member = memberList.get(index-1);
        model.addAttribute("member", member);
        return "update-form";
    }

    // 관리자 페이지 - 회원목록 상세 수정
    @PostMapping("/update-action")
    @ResponseBody
    public String updateMember(@RequestParam int index,
                               @RequestParam String inputName,
                               @RequestParam String inputPw,
                               @RequestParam String inputEmail,
                               @RequestParam LocalDate inputJoindate) {
        Member member = memberList.get(index-1);
        member.setUsername(inputName);
        member.setPassword(inputPw);
        member.setEmail(inputEmail);
        member.setJoindate(inputJoindate);

        memberList.set(index-1, member);
        System.out.println("수정된 회원 정보: " + memberList);
        return "<script>alert('회원 정보가 수정되었습니다.'); location.href='/admin';</script>";
    }

    // 관리자 페이지 - 회원목록 삭제
    // localhost:8080/deleteProduct?index=1
    @GetMapping("/deleteProduct")
    @ResponseBody
    public String deleteProduct(@RequestParam int index){
        memberList.remove(index-1);
        return "<script>alert('회원이 삭제되었습니다.'); location.href='/admin';</script>";
    }
}

