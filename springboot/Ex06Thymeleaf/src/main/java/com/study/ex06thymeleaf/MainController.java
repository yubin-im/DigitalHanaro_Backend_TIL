package com.study.ex06thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("")
    public String main() {
        return "redirect:index";
//        return "forward:index";
        // forward: 내부(세선, 모델) 변수값을 가지고 페이지 이동 (내부 URL로 이동시)
        // redirect: 내부 변수값을 버리고 페이지 이동 ( 타 사이트 이동시)
    }

    @GetMapping("index")
    public String index(Model model) {
        // Model 클래스: 스프링에서 데이터를 담아서 전달하는 용도의 클래스
        // 서블릿 메서드에 매개변수로 선언하면 스프링 컨테이너(컨텍스트)에서 자동 주입된다.
        model.addAttribute("name_text", "홍길동");
        model.addAttribute("server_value", "Hong");
        return "index";  // index.html 동적 HTML로 응답한다.
    }

    // localhost:8080/index-param?id=hong&pw=1234
    @GetMapping("index-param")
    public String indexParam(@RequestParam String id, @RequestParam String pw, Model model) {
        System.out.println("id: " + id);
        System.out.println("pw: " + pw);
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "index";
    }

    // url은 같아도 되고 함수이름만 변경
    @PostMapping("index-param")
    public String indexParamPost(@RequestParam String id, @RequestParam String pw, Model model) {
        System.out.println("id: " + id);
        System.out.println("pw: " + pw);
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "index";
    }

}
