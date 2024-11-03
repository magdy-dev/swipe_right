package com.magdy.swipe_right.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    @Column(name = "preferences")
    private String preferences;

    private String location;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    public User() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }
}