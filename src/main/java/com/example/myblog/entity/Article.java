package com.example.myblog.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter // 게터를 자동 생성!
@ToString // toString() 자동 생성!
@NoArgsConstructor // 디폴트 생성자 넣어 줌!
@Entity // DB 테이블에 저장될 클래스 임!
public class Article extends BaseTime {
    @Id // 이게 ID임! 즉 사람으로 따지면 주민등록 번호! DB에서는 PK(Primary Key)라고 함!
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 자동 관리. 매 생성 시, 1, 2, ... 증가
    private Long id;

    @Column(length = 100, nullable = false) // 최대 100글자, 비어 있으면 안됨!
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 텍스트 타입, 비어있으면 안됨!
    private String content;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private List<Comment> comments;

    @Builder // 빌더 패턴 적용! 추후 사용 시, 설명..!
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // 엔티티 객체 정보를 수정!
    public void rewrite(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
