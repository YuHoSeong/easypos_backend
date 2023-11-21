package com.pcpos.easypos.dto.response.auth;

import java.time.LocalDateTime;

import com.pcpos.easypos.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostSignInResponseDto {
    private String email;
    private String userName;
    private LocalDateTime createdAt;
    private String token;
    private int expirtedTime;

    public PostSignInResponseDto(UserEntity userEntity, String token) {
        this.email = userEntity.getEmail();
        this.userName = userEntity.getUserName();
        this.createdAt = LocalDateTime.now();
        this.token = token;
        this.expirtedTime = 3600000;
    }
}
