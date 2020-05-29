package com.example.myblog.controller;

import com.example.myblog.entity.Article;
import com.example.myblog.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller // 해당 클래스를, 컨트롤러로 선언!
public class HelloController {

    private final ArticleRepository articleRepository;

    @GetMapping("/") // 다음 url 요청을 받음 -> "/"를 보여줘 -> 아래 메소드를 수행!
    public String hello() {
        return "helloworld"; // helloworld.mustache 페이지를 반환!
    }

    @GetMapping("/init") // GET 요청이 해당 url로 오면, 아래 메소드를 수행!
    public String newArticle() {
        // Article 저장용 객체 생성
        List<Article> articleList = new ArrayList<>();

        // Article 생성..!
        for (int i = 0; i < 3; i++) {
            String title = "제목-" + (char)('A' + i);
            String content = "내용..." + i;
            articleList.add(new Article(null, title, content));
        }

        // Article 저장
        articleRepository.saveAll(articleList);

        return "redirect:/articles"; // 보여줄 뷰 페이지
    }

}
