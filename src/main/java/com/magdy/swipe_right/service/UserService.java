package com.magdy.swipe_right.service;

import com.magdy.swipe_right.dto.UserDTO;
import com.magdy.swipe_right.entity.User;
import com.magdy.swipe_right.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setGender(userDTO.getGender());
        user.setPreferences(userDTO.getPreferences());
        user.setLocation(userDTO.getLocation());
        return userRepository.save(user);
    }

    public Optional<User> update(Long id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            User user = userRepository.findById(id).get();
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setEmail(userDTO.getEmail());
            user.setGender(userDTO.getGender());
            user.setPreferences(userDTO.getPreferences());
            user.setLocation(userDTO.getLocation());
            return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
