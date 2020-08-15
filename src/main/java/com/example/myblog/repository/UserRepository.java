package com.example.myblog.repository;

import com.example.myblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 중복 이메일 검증을 위함!
    Optional<User> findByEmail(String email); //
}
