package com.magdy.swipe_right.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    private Long senderId;
    private Long receiverId;
    private String content;
}