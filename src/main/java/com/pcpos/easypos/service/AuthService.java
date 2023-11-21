package com.pcpos.easypos.service;

import com.pcpos.easypos.dto.request.auth.PostSignInDto;
import com.pcpos.easypos.dto.request.auth.PostSignUpDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.auth.PostSignInResponseDto;
import com.pcpos.easypos.dto.response.auth.PostSignUpResponseDto;

public interface AuthService {
    // 회원가입
    public ResponseDto<PostSignUpResponseDto> postSignUp(PostSignUpDto dto);

    // 로그인
    public ResponseDto<PostSignInResponseDto> postSignIn(PostSignInDto dto);
}
