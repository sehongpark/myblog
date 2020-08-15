package com.example.myblog.config.auth;

import com.example.myblog.entity.User;
import com.example.myblog.enums.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey,
                           String name,
                           String email,
                           String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    // OAuth로 전달 받은 값을, 재 규격화 함!
    public static OAuthAttributes of(String registrationId, // 서비스 id
                                     String userNameAttributeName, // 대표 필드
                                     Map<String, Object> attributes) { // 속성 값들
        return _ofGoogle(userNameAttributeName, attributes);
    }

    // 구글 정보를 재규격화
    private static OAuthAttributes _ofGoogle(String userNameAttributeName,
                                           Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    // 신규 유저의 경우 수행!
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
