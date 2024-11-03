package com.magdy.swipe_right.repository;

import com.magdy.swipe_right.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    // Additional query methods can be defined here if needed
    List<Message> findBySenderId(Long senderId);
    List<Message> findByReceiverId(Long receiverId);
}