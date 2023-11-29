package com.pcpos.easypos.dto.response.user;

import com.pcpos.easypos.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponseDto {
    private Integer userIdx;
    private String email;
    private String userName;

    public GetUserResponseDto(UserEntity userEntity){
        this.userIdx = userEntity.getUserIdx();
        this.email = userEntity.getEmail();
        this.userName = userEntity.getUserName();
    }
}
