package com.magdy.swipe_right.repository;

import com.magdy.swipe_right.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    // Additional query methods can be defined here if needed
    List<Match> findByUser1Id(Long user1Id);
    List<Match> findByUser2Id(Long user2Id);
}