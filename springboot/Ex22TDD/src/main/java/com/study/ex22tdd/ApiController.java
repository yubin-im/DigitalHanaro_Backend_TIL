package com.study.ex22tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    MemberService memberService;

    @PostMapping("/loginAction1")
    public ResultDTO loginAction1(@RequestBody ReqDTO reqDTO){
        Member member = Member.builder()
                .loginId(reqDTO.getLoginId())
                .loginPw(reqDTO.getLoginPw())
                .build();

        int result = memberService.loginAction(member);
        ResultDTO resultDto = new ResultDTO();
        if( result == 1 ){
            resultDto.setStatus("ok");
            resultDto.setMessage("로그인 성공!");
        }else{
            resultDto.setStatus("fail");
            resultDto.setMessage("로그인 실패!");
        }

        return resultDto;
    }
}
