package com.study.ex27security01.controller;

import com.study.ex27security01.dto.MemberJoinDto;
import com.study.ex27security01.entity.MemberEntity;
import com.study.ex27security01.entity.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/joinAction")
    @ResponseBody
    public String joinAction(@Valid @ModelAttribute MemberJoinDto dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            String detail = bindingResult.getFieldError().getDefaultMessage();
            String bindResultCode = bindingResult.getFieldError().getCode();
            System.out.println(detail + ": " + bindResultCode);
            return "<script>alert('" + detail + "'; history.back();</script>";
        }

        // 비밀번호는 암호화해서 저장하기
        String encodePassword = passwordEncoder.encode(dto.getPassword());
        System.out.println("encodePassword: " + encodePassword);
        dto.setPassword(encodePassword);

        // 회원가입 DB 액션 수행
        try {
            MemberEntity entity = dto.toSaveEntity();
            memberRepository.save(entity);
        }
        catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "<script>alert('이미 등록된 사용자입니다.'); history.back();</script>";
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "<script>alert('회원가입 실패했습니다.'); history.back();</script>";
        }

        // HTTP 응답 코드: 200 성공
        HttpStatus status = HttpStatus.OK;
        if (status == HttpStatus.OK) {
            System.out.println("회원가입 성공!");
            return "<script>alert('회원가입 성공!'); location.href='/loginForm';</script>";
        } else {
            System.out.println("회원가입 실패");
            return "<script>alert('회원가입 실패했습니다.'); history.back();</script>";
        }
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        long listCount = memberRepository.count();
        model.addAttribute("listCount", listCount);

        List<MemberEntity> list = memberRepository.findAll();
        model.addAttribute("list", list);

        return "admin";
    }
}
