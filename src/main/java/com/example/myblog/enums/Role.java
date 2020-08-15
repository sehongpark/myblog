package com.example.myblog.enums;

import lombok.Getter;

@Getter
public enum Role { // 주의: "Enum"(O), "class"(X)

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;

    // 아래 생성자는 "@RequiredArgsConstructor"로 생략 가능!
    // 참조: https://www.daleseo.com/lombok-popular-annotations/
    Role(String key, String title) {
        this.key = key;
        this.title = title;
    }
}
