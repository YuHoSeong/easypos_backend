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
    private final String DELETE_USER = "/{userId}";

    @GetMapping(GET_USER)
    public ResponseDto<GetUserResponseDto> getUser(@AuthenticationPrincipal String Email) {
        log.info("getUser");
        ResponseDto<GetUserResponseDto> response = userService.getUser(Email);
        return response;
    }

    @PatchMapping(PATCH_USER)
    public ResponseDto<PatchUserResponseDto> patchUser(@AuthenticationPrincipal String Email, @RequestBody PatchUserDto requestBody) {
        log.info("patchUser");
        ResponseDto<PatchUserResponseDto> response =userService.patchUser(Email, requestBody);
        return response;
    }

    @DeleteMapping(DELETE_USER)
    public ResponseDto<DeleteUserResponseDto> deleteUser(@AuthenticationPrincipal String Email){
        log.info("deleteUser");
        ResponseDto<DeleteUserResponseDto> response = userService.deleteUser(Email);
        return response;
    }

}
