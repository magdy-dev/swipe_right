package com.magdy.swipe_right.service;

import com.magdy.swipe_right.dto.MatchDTO;
import com.magdy.swipe_right.entity.Match;
import com.magdy.swipe_right.repository.MatchRepository;
import com.magdy.swipe_right.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Match> findAll() {
        return matchRepository.findAll();
    }

    public Optional<Match> findById(Long id) {
        return matchRepository.findById(id);
    }

    public Match save(MatchDTO matchDTO) {
        Match match = new Match();
        match.setUser1(userRepository.findById(matchDTO.getUser1Id()).orElse(null));
        match.setUser2(userRepository.findById(matchDTO.getUser2Id()).orElse(null));
        return matchRepository.save(match);
    }

    public Optional<Match> update(Long id, MatchDTO matchDTO) {
        if (matchRepository.existsById(id)) {
            Match match = matchRepository.findById(id).get();
            match.setUser1(userRepository.findById(matchDTO.getUser1Id()).orElse(null));
            match.setUser2(userRepository.findById(matchDTO.getUser2Id()).orElse(null));
            return Optional.of(matchRepository.save(match));
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (matchRepository.existsById(id)) {
            matchRepository.deleteById(id);
            return true;
        }
        return false;
    }
}