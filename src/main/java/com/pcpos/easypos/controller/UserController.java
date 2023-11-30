package com.pcpos.easypos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcpos.easypos.common.constants.ApiPattern;
import com.pcpos.easypos.dto.request.user.PatchUserDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.user.DeleteUserResponseDto;
import com.pcpos.easypos.dto.response.user.GetUserResponseDto;
import com.pcpos.easypos.dto.response.user.PatchUserResponseDto;
import com.pcpos.easypos.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(ApiPattern.USER)
@Slf4j
public class UserController {

    @Autowired private UserService userService;

    private final String GET_USER = "/";
    private final String PATCH_USER = "/";
    private final String DELETE_USER = "/";

    // 회원정보조회
    @GetMapping(GET_USER)
    public ResponseDto<GetUserResponseDto> getUser(@AuthenticationPrincipal String email) {
        log.info("getUser");
        ResponseDto<GetUserResponseDto> response = userService.getUser(email);
        return response;
    }

    // 회원정보수정
    @PatchMapping(PATCH_USER)
    public ResponseDto<PatchUserResponseDto> patchUser(@AuthenticationPrincipal String email, @RequestBody PatchUserDto requestBody) {
        log.info("patchUser");
        ResponseDto<PatchUserResponseDto> response =userService.patchUser(email, requestBody);
        return response;
    }

    // 회원탈퇴
    @DeleteMapping(DELETE_USER)
    public ResponseDto<DeleteUserResponseDto> deleteUser(@AuthenticationPrincipal String email){
        log.info("deleteUser");
        ResponseDto<DeleteUserResponseDto> response = userService.deleteUser(email);
        return response;
    }

}
