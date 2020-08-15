package com.example.myblog.entity;

import com.example.myblog.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column
    private String picture;

    // 원래 Enum 값이 DB로 들어가면 숫자로 저장 됨.
    // 근데 숫자만 보면 무슨 의미인지 파악하기 힘듦.
    // 때문에, String 타입으로 저장하기로 설정!
    @Enumerated(EnumType.STRING) // 구글링: "자바 Enum이란?" & "@Enumerated 애노테이션"
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String email, String name, String picture, Role role) {
        this.email = email;
        this.name = name;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}


