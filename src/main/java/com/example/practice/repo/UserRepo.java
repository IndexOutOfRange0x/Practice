package com.example.practice.repo;

import com.example.practice.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    public User findByUserName(String login);
}
