package com.magdy.swipe_right.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String username;
    private String password;
    private String email;
    private String gender;
    private String preferences;
    private String location;
}