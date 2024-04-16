package com.study.ex15readdbcrud.controller;

import com.study.ex15readdbcrud.dto.ReplySaveRequestDto;
import com.study.ex15readdbcrud.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    final private ReplyService replyService;

    @PostMapping("/writeReplyAction")
    @ResponseBody
    public String writeReplyAction(@ModelAttribute ReplySaveRequestDto dto,
                                   @RequestParam Long replyBoardIdx ){
        Long newReplyIdx = replyService.save( dto );

        boolean isFound = replyService.existsById( newReplyIdx );
        if( isFound == true ){
            return "<script>alert('댓글쓰기 성공'); location.href='/';</script>";
        }else{
            return "<script>alert('댓글쓰기 실패'); history.back();</script>";
        }
    }
}