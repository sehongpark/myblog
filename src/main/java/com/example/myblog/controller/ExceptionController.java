package com.example.myblog.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.example.myblog.controller")
public class ExceptionController {

    @ExceptionHandler(IllegalArgumentException.class)
    public String notFound(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "errors/404-error"; // 해당 페이지를 보여 줌!
    }
}
