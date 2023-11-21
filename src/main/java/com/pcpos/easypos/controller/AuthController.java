package com.pcpos.easypos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcpos.easypos.common.constants.ApiPattern;
import com.pcpos.easypos.dto.request.auth.PostSignInDto;
import com.pcpos.easypos.dto.request.auth.PostSignUpDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.auth.PostSignInResponseDto;
import com.pcpos.easypos.dto.response.auth.PostSignUpResponseDto;
import com.pcpos.easypos.service.AuthService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(ApiPattern.AUTH)
@Slf4j
public class AuthController {
    @Autowired private AuthService authService;

    private final String SIGN_UP = "/sign-up";
    private final String SIGN_IN = "/sign-in";

    @PostMapping(SIGN_UP)
    public ResponseDto<PostSignUpResponseDto> postSignUp(@Valid @RequestBody PostSignUpDto requestBody){
        log.info("SIGN_UP");
        ResponseDto<PostSignUpResponseDto> response = authService.postSignUp(requestBody);
        return response;
    }

    @PostMapping(SIGN_IN)
    public ResponseDto<PostSignInResponseDto> postSignIn(@Valid @RequestBody PostSignInDto requestBody) {
        log.info("SIGN_IN");
        ResponseDto<PostSignInResponseDto> response = authService.postSignIn(requestBody);
        return response;
    }
}
