package com.example.myblog.dto;

import com.example.myblog.entity.Comment;
import lombok.Data;

@Data
public class CommentForm {

    private Long id;
    private String author;
    private String content;

    public Comment toEntity() {
        return Comment.builder()
                .id(id)
                .author(author)
                .content(content)
                .build();
    }
}