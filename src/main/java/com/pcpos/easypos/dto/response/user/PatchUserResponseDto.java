package com.pcpos.easypos.dto.response.user;

import com.pcpos.easypos.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchUserResponseDto {
    private String email;
    private String userName;

    public PatchUserResponseDto(UserEntity userEntity){
        this.email = userEntity.getEmail();
        this.userName = userEntity.getUserName();
    }
}
