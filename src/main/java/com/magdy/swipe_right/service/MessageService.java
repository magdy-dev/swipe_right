package com.magdy.swipe_right.service;

import com.magdy.swipe_right.dto.MessageDTO;
import com.magdy.swipe_right.entity.Message;
import com.magdy.swipe_right.repository.MessageRepository;
import com.magdy.swipe_right.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public Optional<Message> findById(Long id) {
        return messageRepository.findById(id);
    }

    public Message save(MessageDTO messageDTO) {
        Message message = new Message();
        message.setSender(userRepository.findById(messageDTO.getSenderId()).orElse(null));
        message.setReceiver(userRepository.findById(messageDTO.getReceiverId()).orElse(null));
        message.setContent(messageDTO.getContent());
        return messageRepository.save(message);
    }

    public Optional<Message> update(Long id, MessageDTO messageDTO) {
        if (messageRepository.existsById(id)) {
            Message message = messageRepository.findById(id).get();
            message.setContent(messageDTO.getContent());
            return Optional.of(messageRepository.save(message));
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (messageRepository.existsById(id)) {
            messageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}