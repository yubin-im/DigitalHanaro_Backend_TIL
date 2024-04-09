package com.study.ex15readdbcrud.controller;

import com.study.ex15readdbcrud.dao.IMemberDao;
import com.study.ex15readdbcrud.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {
    // 생성자 주입
    final IMemberDao memberDao;

    @GetMapping("/")
    public String main() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<MemberDTO> list = memberDao.list();
        model.addAttribute("member_list", list);
        int count = memberDao.count();
        model.addAttribute("listcount", count);

        return "index";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/joinAction")
    @ResponseBody
    public String joinAction(@ModelAttribute MemberDTO dto) {
        System.out.println("name: " + dto.getUserName());

        try {
            int result = memberDao.insert(dto);
            if(result != 1) {
                return "<script>alert('회원가입 실패');history.back();</script>";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("회원가입 실패");
        }
        return "<script>alert('회원가입 성공');location.href='/list';</script>";
    }

    @GetMapping("/viewMember")
    public String viewMember(@RequestParam int id, Model model) {
        List<MemberDTO> list = memberDao.findById(id);
        if(list == null || list.size() == 0) {
            System.out.println("회원정보가 없습니다.");
            return "redirect:/list";
        }

        model.addAttribute("member", list.get(0));
        System.out.println("userName: " + list.get(0).getUserName());

        return "modifyForm";
    }

    @PostMapping("/modifyAction")
    @ResponseBody
    public String modifyAction(@ModelAttribute MemberDTO dto){
        try{
            int result = memberDao.update( dto );
            if( result != 1 ){
                System.out.println("회원정보수정 실패");
                return "<script>alert('회원정보수정 실패');history.back();</script>";
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("회원정보수정 실패");
            return "<script>alert('회원정보수정 실패');history.back();</script>";
        }
        System.out.println("회원정보수정 성공");
        return "<script>alert('회원정보수정 성공');location.href='/list';</script>";
    }

    @GetMapping("/deleteMember")
    @ResponseBody
    public String deleteMember(@RequestParam int id){
        try{
            int result = memberDao.delete(id);
            // int result = memberDao.deleteMap( 1, "hong3" );
            if (result != 1) {
                return "<script>alert('회원정보삭제 실패');history.back();</script>";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "<script>alert('회원정보삭제 실패');history.back();</script>";
        }
        return "<script>alert('회원정보삭제 성공');location.href='/list';</script>";
    }
}
