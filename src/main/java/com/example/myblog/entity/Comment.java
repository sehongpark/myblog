package com.example.myblog.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String author;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    // 해당 댓글이 어느 게시글에 작성된 것인지를 기록!
    public void stickTo(Article article) {
        this.article = article;
    }
}
