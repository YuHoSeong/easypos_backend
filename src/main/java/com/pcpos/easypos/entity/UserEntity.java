package com.pcpos.easypos.entity;

import java.time.LocalDateTime;

import com.pcpos.easypos.dto.request.auth.PostSignUpDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="User")
@Table(name="User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userIdx;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime createdAt;
    
    public UserEntity(PostSignUpDto dto) {
        this.email = dto.getEmail();
        this.userName = dto.getUserName();
        this.password = dto.getPassword();
        this.createdAt = LocalDateTime.now();
    }
}
