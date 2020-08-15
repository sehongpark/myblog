package com.example.myblog.config.auth;

import com.example.myblog.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // 스프링 시큐리티 설정 활성화 해줌!
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // h2-console 사용을 위해! 구글링 "csrf 란?"
                .csrf().disable()
                .headers().frameOptions().disable()
            .and()
                // URL에 따른 설정 시작!
                .authorizeRequests()
                .antMatchers( // 아래 패턴의 URL은,
                        "/",
                        "/articles",
                        "/init",
                        "/css/**",
                        "/images/**",
                        "/js/**",
                        "/h2-console/**"
                ).permitAll() // 누구나 접근하게 한다!
                .antMatchers( // 아래 패턴의 URL은,
                        "/api/**"
                ).hasRole(Role.USER.name()) // "USER"인 경우만 사용 가능! hasRole("USER")와 같음! 참조: "자바 enum name()"
                .anyRequest().authenticated() // 나머지 URL 요청은 무조건 인증 해야 함!
            .and()
                .logout()
                    .logoutSuccessUrl("/") // 로그아웃 후, 리다이렉트 될 URL
            .and()
                .oauth2Login() // OAuth2 로그인 관련 설정
                    .userInfoEndpoint() // 로그인 성공 시, 사용자 정보 관련 설정
                        .userService(customOAuth2UserService); // 로그인 성공 후, 사용자를 다룰 서비스를 등록!
    }
}
