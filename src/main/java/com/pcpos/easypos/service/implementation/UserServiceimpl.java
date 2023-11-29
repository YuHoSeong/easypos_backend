package com.pcpos.easypos.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcpos.easypos.common.constants.ResponseMessage;
import com.pcpos.easypos.dto.request.user.PatchUserDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.user.DeleteUserResponseDto;
import com.pcpos.easypos.dto.response.user.GetUserResponseDto;
import com.pcpos.easypos.dto.response.user.PatchUserResponseDto;
import com.pcpos.easypos.entity.UserEntity;
import com.pcpos.easypos.repository.UserRepository;
import com.pcpos.easypos.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceimpl implements UserService{

    @Autowired UserRepository userRepository;

    // 관리자 정보 조회()
    @Override
    public ResponseDto<GetUserResponseDto> getUser(String email) {
        GetUserResponseDto data = null;

        try {
            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER_EAMIL);
            log.info("findByEmail : {}",userEntity);
    
            data = new GetUserResponseDto(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 관리자 정보 수정(유저dto)
    @Override
    public ResponseDto<PatchUserResponseDto> patchUser(String email, PatchUserDto dto) {
        PatchUserResponseDto data = null;

        try {
            boolean hasEmail = userRepository.existsByEmail(email);
            if(!hasEmail) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER_EAMIL);

            UserEntity updatedUserEntity = userRepository.save(new UserEntity(dto));

            data = new PatchUserResponseDto(updatedUserEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 회원 탈퇴()
    @Override
    public ResponseDto<DeleteUserResponseDto> deleteUser(String email) {
        DeleteUserResponseDto data = null;

        try {
            boolean hasEmail = userRepository.existsByEmail(email);
            if(!hasEmail) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER_EAMIL);

            userRepository.deleteByEmail(email);

            data = new DeleteUserResponseDto(true);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
}
