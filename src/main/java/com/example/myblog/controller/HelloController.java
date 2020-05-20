package com.example.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 해당 클래스를, 컨트롤러로 선언!
public class HelloController {
    @GetMapping("/") // 다음 url 요청을 받음 -> "/"를 보여줘 -> 아래 메소드를 수행!
    public String hello(Model model) { // 모델 객체를 가져옴!
        // 데이터를 뷰 페이지로 전달!
        // key(변수명): "msg",
        // value(내용): "안녕하세요, 반갑습니다!"
        model.addAttribute("msg", "안녕하세요, 반갑습니다!");
        return "helloworld"; // helloworld.mustache 페이지를 반환!
    }
}
