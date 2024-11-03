package com.magdy.swipe_right.repository;

import com.magdy.swipe_right.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods can be defined here if needed
    User findByUsername(String username);
    User findByEmail(String email);
}