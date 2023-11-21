package com.pcpos.easypos.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pcpos.easypos.common.constants.ResponseMessage;
import com.pcpos.easypos.dto.request.auth.PostSignInDto;
import com.pcpos.easypos.dto.request.auth.PostSignUpDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.auth.PostSignInResponseDto;
import com.pcpos.easypos.dto.response.auth.PostSignUpResponseDto;
import com.pcpos.easypos.entity.UserEntity;
import com.pcpos.easypos.provider.TokenProvider;
import com.pcpos.easypos.repository.UserRepository;
import com.pcpos.easypos.service.AuthService;

@Service
public class AuthServiceimpl implements AuthService {

    @Autowired private TokenProvider tokenProvider;
    @Autowired private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 회원가입
    @Override
    public ResponseDto<PostSignUpResponseDto> postSignUp(PostSignUpDto dto) {
        PostSignUpResponseDto data = null;

        String email = dto.getEmail();
        String password = dto.getPassword();
        try {
            boolean hasEmail = userRepository.existsByEmail(email);
            if (hasEmail) return ResponseDto.setFailed(ResponseMessage.EXIST_EMAIL);

            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

            data = new PostSignUpResponseDto(true);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 로그인
    @Override
    public ResponseDto<PostSignInResponseDto> postSignIn(PostSignInDto dto) {
        PostSignInResponseDto data = null;

        String email = dto.getEmail();
        String password = dto.getPassword();

        UserEntity userEntity = null;

        try {
            userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);
            
        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        boolean isEqualPassword = passwordEncoder.matches(password, userEntity.getPassword());
        if (!isEqualPassword) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);

        try {
            String token = tokenProvider.create(email);
            data = new PostSignInResponseDto(userEntity, token);
        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);
        }


        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
}
