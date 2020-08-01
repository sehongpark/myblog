package com.example.myblog.api;

import com.example.myblog.dto.CommentForm;
import com.example.myblog.entity.Article;
import com.example.myblog.entity.Comment;
import com.example.myblog.repository.ArticleRepository;
import com.example.myblog.repository.CommentRepository;
import com.example.myblog.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService commentService; // 서비스 레이어 객체

    @PostMapping("/api/comments/{articleId}")
    public Long create(@PathVariable Long articleId,
                       @RequestBody CommentForm form) {
        // 서비스 객체가 댓글 생성
        Comment saved = commentService.create(articleId, form);
        log.info("saved: " + saved.toString());
        return saved.getId();
    }
}